package com.sugang.ex;

import java.util.ArrayList;

import com.sugang.dao.SugangDao;
import com.sugang.dto.DtoJoinClass;
import com.sugang.dto.DtoSugang;
import com.sugang.util.DBConn;
import com.sugang.util.DBInput;

public class SugangMain {

	public static void main(String[] args) {
		try {
			SugangDao dao = new SugangDao();

			DBConn.getInstance();
			System.out.println("Enter your id >>");
			SugangDao.st_no = DBInput.inputString();

			boolean isFlag=true;
			while(isFlag) {

				System.out.println("수강신청  \n 1.신청  2. 변경 "
						+ " 3. 취소  4. 전체 강의 조회 5. 종료");
				switch(DBInput.inputInt()) {
					case 1:
						//insert
						System.out.println("수강신청");
						System.out.println("강의명을 입력해주세요 >>");
						String class_no = DBInput.inputString();
						System.out.println("학점을 입력해주세요 >>");
						int class_credit = DBInput.inputInt();
						DtoSugang dto = new DtoSugang(SugangDao.st_no,class_no,class_credit);

						int result = dao.insert(dto);

						System.out.println(result+"신청되었습니다.");
						break;
					case 2:
						//update
						System.out.println("변경할 강의명을 입력해주세요 >>");
						String name1 = DBInput.inputString();
						System.out.println("새로운 강의명을 입력해주세요 >>");
						String name2 = DBInput.inputString();
						dao.update(name1, name2);

						System.out.println(name1+"가 " +name2+"로 변경되었습니다.");
						break;
					case 3:
						//delete
						System.out.println("취소할 강의명을 입력해주세요 >>");
						String name3 = DBInput.inputString();

						dao.delete(name3);

						System.out.println(name3+"가 취소되었습니다.");
						break;
					case 4:
						//강의 목록 조회
						System.out.print("강의목록");

						ArrayList<DtoJoinClass> calssDtos = dao.joinClass();

						System.out.println("학생이 신청한 강의 목록 입니다.");
						for(DtoJoinClass sClassDto:calssDtos) {
							System.out.println(sClassDto);
						}
						break;
					case 5:
						System.out.println("종ㄽ");
						isFlag=false;
				}
			}
		} catch (Exception e) {
			System.out.println("에러가 발생하였습니다~! " +  e.getMessage());
		}
	}
}
