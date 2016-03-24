package com.bobo.trace;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.bobo.adapters.TraceAdapter;
import com.bobo.beans.Trace;


public class MainActivity extends Activity {

	private ListView lv_trace;
	private ArrayList<Trace> tradeLists = new ArrayList<Trace>();
	private TraceAdapter ta;
	
	private Context context;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        context = MainActivity.this;
        
        initView();
        
    }

    private void initView(){
    	lv_trace = (ListView)findViewById(R.id.lv_trace);
    	initData();
    	
    	ta = new TraceAdapter(tradeLists, context);
    	lv_trace.setAdapter(ta);
    }

    private void initData(){
    	
    	tradeLists.add(new Trace(true, "商家已从广东发货", "15253157943", "2016-03-16 13:30:43"));
    	tradeLists.add(new Trace(false, "货物正在配送", "", "2016-03-16 18:30:43"));
    	tradeLists.add(new Trace(false, "货物已到达天津转运中心", "", "2016-03-17 13:30:43"));
    	tradeLists.add(new Trace(false, "货品已到济南货运站", "", "2016-03-18 13:30:43"));
    	tradeLists.add(new Trace(false, "货物已送达济南高新区站点", "", "2016-03-19 13:30:43"));
    }
}
