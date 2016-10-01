package com.zzb.mennu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzb.mennu.wight.LazyFragment;

public class DFrag extends LazyFragment {
	View v;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
//		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//		View v=new View(getActivity());
//		v.setLayoutParams(params);
//		v.setBackgroundResource(android.R.color.holo_purple);
		v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_my_order,container,false);
		return v;
	}

	@Override
	protected void lazyLoad() {

	}
}
