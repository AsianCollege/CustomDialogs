package com.asmt.listngrid;

import com.asmt.listngrid.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	
	private Context contxt;
	private final String[] listTitle;
	private final int[] listImage;
	private final String[] listDesc;
	private final int resource;
	LayoutInflater inflater;

	public CustomAdapter(Context ctx, int res, String[] lt,int[] li,String[] ld) {
		this.contxt = ctx;
		this.listTitle = lt;
		this.listImage = li;
		this.listDesc = ld;
		resource = res;
		inflater = (LayoutInflater)this.contxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}
	
	public static class ViewHolder{
		public ImageView thumb;
		public TextView title;
		public TextView desc;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listTitle.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		View vi = convertView;
		if(vi == null){
			vi = inflater.inflate(resource,null);
			holder = new ViewHolder();
			holder.title = (TextView)vi.findViewById(R.id.listTitle);
			holder.desc = (TextView)vi.findViewById(R.id.listDesc);
			holder.thumb = (ImageView)vi.findViewById(R.id.listImage);
			vi.setTag(holder);
		}else{
			holder=(ViewHolder)vi.getTag();
		}
		holder.title.setText(this.listTitle[position]);
		holder.desc.setText(this.listDesc[position]);
		holder.thumb.setImageResource(this.listImage[position]);		
		
		return vi;
	}

}
