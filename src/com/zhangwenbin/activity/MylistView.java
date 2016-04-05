package com.zhangwenbin.activity;

import com.umeng.socialize.view.wigets.PullToRefreshListView.OnRefreshListener;
import com.zhangshun.keep_in_good_health.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MylistView extends ListView implements OnScrollListener {

	private final static int RELEASE_TO_REFRESH = 0;
	private final static int PULL_TO_REFRESH = 1;
	private final static int REFRESHING = 2;
	private final static int DONE = 3;
	private final static int LOADING = 4;

	private final static int RATIO = 3;
	LayoutInflater inflater;

	LinearLayout headerView;
	TextView lvHeaderTipsTv;
	TextView lvHeaderLastUpdatedTv;
	ImageView lvHeaderArrowIv;
	ProgressBar lvHeaderProgressBar;

	int headerContentHeight;
	RotateAnimation animation;
	RotateAnimation reverseAnimotion;

	int startY;
	int state;
	boolean isBack;

	boolean isRecored;
	OnRefreshListener refreshListener;
	boolean isRefreshable;

	public MylistView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MylistView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public void init(Context context) {
		inflater = LayoutInflater.from(context);
		headerView = (LinearLayout) inflater.inflate(R.layout.myrecords_list_refresh_header, null);
		lvHeaderTipsTv = (TextView) headerView.findViewById(R.id.myrecords_listview_header_hint_textview);
		lvHeaderLastUpdatedTv = (TextView) headerView.findViewById(R.id.myrecords_listview_header_last_time);

		lvHeaderArrowIv = (ImageView) headerView.findViewById(R.id.myrecords_listview_header_arrow);
		lvHeaderArrowIv.setMinimumWidth(70);
		lvHeaderArrowIv.setMinimumHeight(50);

		lvHeaderProgressBar = (ProgressBar) headerView.findViewById(R.id.myrecords_listview_header_progressbar);
		//measureView(headerView);
		headerContentHeight = headerView.getMeasuredHeight();
		headerView.setPadding(0, -1 * headerContentHeight, 0, 0);

		headerView.invalidate();
		addHeaderView(headerView);
		setOnScrollListener(this);

		animation = new RotateAnimation(0, 100, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		reverseAnimotion.setInterpolator(new LinearInterpolator());
		reverseAnimotion.setDuration(200);
		reverseAnimotion.setFillAfter(true);

		state = DONE;
		isRefreshable = false;

	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		if (firstVisibleItem == 0) {
			isRefreshable = true;
		} else {
			isRefreshable = false;
		}
	}

	@Override
	public void onScrollStateChanged(AbsListView arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	public boolean onTouchEvent(MotionEvent event) {
		if (isRefreshable) {
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				if (!isRecored) {
					isRecored = true;
					startY = (int) event.getY();// 手指按下时记录当前位置
				}
				break;
			case MotionEvent.ACTION_UP:
				if (state != REFRESHING && state != LOADING) {
					if (state == PULL_TO_REFRESH) {
						state = DONE;
						changeHeaderViewByState();
					}
					if (state == RELEASE_TO_REFRESH) {
						state = REFRESHING;
						changeHeaderViewByState();
						//onLvRefresh();
					}
				}
				isRecored = false;
				isBack = false;
				break;
			case MotionEvent.ACTION_MOVE:
				int tempY = (int) event.getY();
				if (!isRecored) {
					isRecored = true;
					startY = tempY;
				}
				if (state != REFRESHING && isRecored && state != LOADING) {
					// 保证在设置padding的过程中，当前的位置一直是在head，否则如果当列表超出屏幕的话，当在上推的时候，列表会同时进行滚动
					// 可以松手去刷新了
					if (state == RELEASE_TO_REFRESH) {
						setSelection(0);
						// 往上推了，推到了屏幕足够掩盖head的程度，但是还没有推到全部掩盖的地步
						if (((tempY - startY) / RATIO < headerContentHeight)// 由松开刷新状态转变到下拉刷新状态
								&& (tempY - startY) > 0) {
							state = PULL_TO_REFRESH;
							changeHeaderViewByState();
						}
						// 一下子推到顶了
						else if (tempY - startY <= 0) {// 由松开刷新状态转变到done状态
							state = DONE;
							changeHeaderViewByState();
						}
					}
					// 还没有到达显示松开刷新的时候,DONE或者是PULL_To_REFRESH状态
					if (state == PULL_TO_REFRESH) {
						setSelection(0);
						// 下拉到可以进入RELEASE_TO_REFRESH的状态
						if ((tempY - startY) / RATIO >= headerContentHeight) {// 由done或者下拉刷新状态转变到松开刷新
							state = RELEASE_TO_REFRESH;
							isBack = true;
							changeHeaderViewByState();
						}
						// 上推到顶了
						else if (tempY - startY <= 0) {// 由DOne或者下拉刷新状态转变到done状态
							state = DONE;
							changeHeaderViewByState();
						}
					}
					// done状态下
					if (state == DONE) {
						if (tempY - startY > 0) {
							state = PULL_TO_REFRESH;
							changeHeaderViewByState();
						}
					}
					// 更新headView的size
					if (state == PULL_TO_REFRESH) {
						headerView.setPadding(0, -1 * headerContentHeight + (tempY - startY) / RATIO, 0, 0);

					}
					// 更新headView的paddingTop
					if (state == RELEASE_TO_REFRESH) {
						headerView.setPadding(0, (tempY - startY) / RATIO - headerContentHeight, 0, 0);
					}

				}
				break;

			default:
				break;
			}
		}
		return super.onTouchEvent(event);
	}
	
	// 当状态改变时候，调用该方法，以更新界面  
	    private void changeHeaderViewByState() {  
	        switch (state) {  
	        case RELEASE_TO_REFRESH:  
	            lvHeaderArrowIv.setVisibility(View.VISIBLE);  
	            lvHeaderProgressBar.setVisibility(View.GONE);  
	            lvHeaderTipsTv.setVisibility(View.VISIBLE);  
	            lvHeaderLastUpdatedTv.setVisibility(View.VISIBLE);  
	  
	            lvHeaderArrowIv.clearAnimation();// 清除动画  
	            lvHeaderArrowIv.startAnimation(animation);// 开始动画效果  
	  
	            lvHeaderTipsTv.setText("松开刷新");  
	            break;  
	        case PULL_TO_REFRESH:  
	            lvHeaderProgressBar.setVisibility(View.GONE);  
	            lvHeaderTipsTv.setVisibility(View.VISIBLE);  
	            lvHeaderLastUpdatedTv.setVisibility(View.VISIBLE);  
	            lvHeaderArrowIv.clearAnimation();  
	            lvHeaderArrowIv.setVisibility(View.VISIBLE);  
	            // 是由RELEASE_To_REFRESH状态转变来的  
	            if (isBack) {  
	                isBack = false;  
	                lvHeaderArrowIv.clearAnimation();  
	                lvHeaderArrowIv.startAnimation(reverseAnimotion);  
	  
	                lvHeaderTipsTv.setText("下拉刷新");  
	            } else {  
	                lvHeaderTipsTv.setText("下拉刷新");  
	            }  
	            break;  
	  
	        case REFRESHING:  
	  
	            headerView.setPadding(0, 0, 0, 0);  
	  
	            lvHeaderProgressBar.setVisibility(View.VISIBLE);  
	            lvHeaderArrowIv.clearAnimation();  
	            lvHeaderArrowIv.setVisibility(View.GONE);  
	            lvHeaderTipsTv.setText("正在刷新...");  
	            lvHeaderLastUpdatedTv.setVisibility(View.VISIBLE);  
	            break;  
	        case DONE:
	            headerView.setPadding(0, -1 * headerContentHeight, 0, 0);  
	  
	            lvHeaderProgressBar.setVisibility(View.GONE);  
	            lvHeaderArrowIv.clearAnimation();  
	            lvHeaderArrowIv.setImageResource(R.drawable.xlistview_arrow);
	            lvHeaderTipsTv.setText("下拉刷新");  
	            lvHeaderLastUpdatedTv.setVisibility(View.VISIBLE);  
	            break;  
	        }  
	    }
	    
	    // 此方法直接照搬自网络上的一个下拉刷新的demo，此处是“估计”headView的width以及height  
	       /* private void measureView(View child) {  
	            ViewGroup.LayoutParams params = child.getLayoutParams();  
	            if (params == null) {
	                params = new ViewGroup.LayoutParams(  
	                        ViewGroup.LayoutParams.FILL_PARENT,  
	                        ViewGroup.LayoutParams.WRAP_CONTENT);  
	            }  
	            int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0,  
	                    params.width);  
	            int lpHeight = params.height;  
	            int childHeightSpec;  
	            if (lpHeight > 0) {  
	                childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight,  
	                        MeasureSpec.EXACTLY);  
	            } else {  
	                childHeightSpec = MeasureSpec.makeMeasureSpec(0,  
	                        MeasureSpec.UNSPECIFIED);  
	            }  
	            child.measure(childWidthSpec, childHeightSpec);  
	        }  
	      
	        public void setonRefreshListener(OnRefreshListener refreshListener) {  
	            this.refreshListener = refreshListener;  
	            isRefreshable = true;  
	        }  
	     
	        public interface OnRefreshListener {  
	            public void onRefresh();  
	        }  
	      
	        public void onRefreshComplete() {  
	            state = DONE;  
	            lvHeaderLastUpdatedTv.setText("最近更新:" + new Date().toLocaleString());  
	            changeHeaderViewByState();  
	        }  
	      
	        private void onLvRefresh() {  
	            if (refreshListener != null) {  
	                refreshListener.onRefresh();  
	            }  
	        }  
	      
	        public void setAdapter(LvAdapter adapter) {  
	            lvHeaderLastUpdatedTv.setText("最近更新:" + new Date().toLocaleString());  
	            super.setAdapter(adapter);  
	        }  */



}
