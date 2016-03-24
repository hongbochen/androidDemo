package com.bobo.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bobo.beans.Trace;
import com.bobo.trace.R;

public class TraceAdapter extends BaseAdapter {

	private ArrayList<Trace> tradeLists = null;
	private LayoutInflater inflater;
	private Context context;
	
	
	public TraceAdapter(ArrayList<Trace> tradeLists,Context context){
		this.tradeLists = tradeLists;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return tradeLists == null ? 0 : tradeLists.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return tradeLists.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder;
		
		if(convertView == null){
			convertView = inflater.inflate(R.layout.trace_item, null);
			holder = new Holder();
			
			holder.v_up_line = (View)convertView.findViewById(R.id.v_up_line);
			holder.iv_state = (ImageView)convertView.findViewById(R.id.iv_state);
			holder.tv_trace_info = (TextView)convertView.findViewById(R.id.tv_trace_info);
			holder.ll_trace_phone = (LinearLayout)convertView.findViewById(R.id.ll_trace_phone);
			holder.tv_phone = (TextView)convertView.findViewById(R.id.tv_phone);
			holder.tv_trace_time = (TextView)convertView.findViewById(R.id.tv_trace_time);
			holder.v_down_line = (View)convertView.findViewById(R.id.v_down_line);
		
			convertView.setTag(holder);
		}else{
			holder = (Holder)convertView.getTag();
		}
		
		if(tradeLists.get(position).isHead()){
			holder.v_up_line.setVisibility(View.GONE);
			//holder.iv_state = (ImageView)convertView.findViewById(R.id.iv_state);
			holder.tv_trace_info.setText(tradeLists.get(position).getInfo());

			holder.tv_phone.setText(tradeLists.get(position).getPhone());
			holder.tv_trace_time.setText(tradeLists.get(position).getTime());
			holder.v_down_line.setVisibility(View.VISIBLE);
		}else if(tradeLists.size() == (position+1)){
			holder.tv_trace_info.setText(tradeLists.get(position).getInfo());
			holder.ll_trace_phone.setVisibility(View.GONE);
			holder.tv_trace_time.setText(tradeLists.get(position).getTime());
			holder.v_down_line.setVisibility(View.GONE);
		}else{
			holder.tv_trace_info.setText(tradeLists.get(position).getInfo());
			holder.ll_trace_phone.setVisibility(View.GONE);
			holder.tv_trace_time.setText(tradeLists.get(position).getTime());
			holder.v_down_line.setVisibility(View.VISIBLE);
		}
		
		
		return convertView;
	}
	
	class Holder{
		View v_up_line;
		ImageView iv_state;
		TextView tv_trace_info;
		LinearLayout ll_trace_phone;
		TextView tv_phone;
		TextView tv_trace_time;
		View v_down_line;
	}

}
