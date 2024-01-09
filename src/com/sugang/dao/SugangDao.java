package com.sugang.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sugang.dto.DtoJoinClass;
import com.sugang.dto.DtoSugang;
import com.sugang.util.DBConn;

public class SugangDao {
	public static String st_no;
	//insert
	public int insert(DtoSugang dtosugang) throws Exception {
		int returnValue=0;
		String sql="insert into sugang values ('%s', '%s',%d)";
		sql=String.format(sql,dtosugang.getSt_no(),dtosugang.getClass_no(),
				dtosugang.getClass_credit());
		System.out.println(sql);
		returnValue=DBConn.statementUpdate(sql);
		DBConn.dbReset();
		return returnValue;
	}
	//update
	public int update(String class_no, String re_class_no) throws Exception {
		int returnValue=0;
		System.out.println(class_no+":"+re_class_no);
		String sql="update sugang set class_no= '%s' where class_no='%s'and student_no='%s'";
		sql=String.format(sql,  re_class_no, class_no, st_no);
		System.out.println(sql);;
		returnValue=DBConn.statementUpdate(sql);
		DBConn.dbReset();
		return returnValue;
	}
	//delete
	public int delete(String class_no) throws Exception {
		int returnValue=0;
		String sql="delete sugang where class_no='%s' and student_no='%s'";
		sql=String.format(sql,class_no, st_no);
		System.out.println(sql);
		DBConn.statementUpdate(sql);
		DBConn.dbReset();
		return returnValue;
	}
	//전체 강의 목록 조회
	public ArrayList<DtoJoinClass> joinClass() throws Exception {
		ArrayList<DtoJoinClass> arr= new ArrayList<DtoJoinClass>();
		String sql="select c.class_name, c.class_no, s.student_no " + 
				"from sugang s " + 
				"right outer join class c on s.class_no = c.class_no";
		System.out.println(sql);
		ResultSet rs=DBConn.statementQuery(sql);
			while(rs.next()) {
//				System.out.println(rs.getString("class_name")+":"
//			+rs.getString("student_no"));
				arr.add(new DtoJoinClass(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3)
						));
			}
		DBConn.dbReset();
		return arr;
	}
}
