package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.model.Banar;



public interface AdmBanarDao {
	public List<Banar >findBanar();
	public boolean deleteBanar(int banarid);//删除导航
	public boolean addBanar(Banar  banar );//添加导航
	public Banar findBanarByid(int  banarid); //根据名称查找导航
	public boolean updateBanar(Banar  Banar );//更新导航
}
