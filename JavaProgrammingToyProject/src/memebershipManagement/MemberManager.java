package memebershipManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberManager {

	private BufferedReader br;
	private MemberDAO memberDAO;

	public MemberManager() {
		br = new BufferedReader(new InputStreamReader(System.in));
		memberDAO = new MemberDAO();
	}

	public void readMenu() throws IOException {

		int chooseNumber = -1;
		boolean k = true;
		String choice;

		while (k) {

			display();
			choice = br.readLine();
			chooseNumber = Integer.parseInt(choice);

			switch (chooseNumber) {
			case 1: {
				memberDAO.getMemberList();
				break;
			}
			case 2: {
				Member member = new Member();
				String msg;

				System.out.print("아이디를 입력하세요(형식 M-00001) : ");
				msg = br.readLine();
				if (validId(msg)) {
					member.setMember_id(msg);
				} else {
					break;
				}
				System.out.print("이름을 입력하세요 : ");
				msg = br.readLine();
				if (validName(msg)) {
					member.setName(msg);
				} else {
					break;
				}
				System.out.print("전화번호를 입력하세요 : ");
				msg = br.readLine();
				if (validPhoneNuber(msg)) {
					member.setPhone_number(msg);
				} else {
					break;
				}
				memberDAO.insertMember(member);
				System.out.println("---> 회원가입에 성공하셨습니다.");
				break;
			}
			case 3: {
				Member member = new Member();
				String msg;

				System.out.print("수정할 아이디를 입력하세요(형식 M-00001) : ");
				msg = br.readLine();
				if(validUpdateId(msg)) {
					member.setMember_id(msg);					
				} else {
					break;
				}
				System.out.print("수정할 전화번호를 입력하세요 : ");
				msg = br.readLine();
				if(validPhoneNuber(msg)) {
					member.setPhone_number(msg);					
				} else {
					break;
				}
				memberDAO.updateMember(member);
				System.out.println("---> 회원수정에 성공하셨습니다.");
				break;
			}
			case 4: {
				Member member = new Member();
				String msg;
				
				System.out.print("삭제할 아이디를 입력하세요(형식 M-00001) : ");
				msg = br.readLine();
				if(validDeleteId(msg)) {
					member.setMember_id(msg);					
				} else {
					break;
				}
				memberDAO.deleteMember(member);
				System.out.println("---> " + member.getMember_id() + "회원 삭제에 성공하셨습니다.");
				break;
			}
			case 0: {
				k = false;
				break;
			}
			default:
				System.out.println("번호를 잘 못 입력하셨습니다.");
			}
		}
	}

	public void display() {

		System.out.println("목록을 원하시면 1번을 입력하세요.");
		System.out.println("등록을 원하시면 2번을 입력하세요.");
		System.out.println("수정을 원하시면 3번을 입력하세요.");
		System.out.println("삭제를 원하시면 4번을 입력하세요.");
		System.out.println("종료를 원하시면 0번을 입력하세요.");
	}

	public boolean validId(String id) {

		Member member = memberDAO.findMember(id);
		if (id.isBlank()) {
			System.out.println("아이디는 필수 입력항목입니다.");
			return false;
		} else if (id.charAt(0) != 'M' || id.length() != 7) {
			System.out.println("아이디는 'M-'로 시작해야 하며, M-를 포함하여 7개의 문자로 구성해야 합니다.");
			return false;
		} else if (member.getMember_id() == "true") {
			return true;
		} else {
			System.out.println(id + "가 이미 존재합니다.");
			return false;
		}
	}

	public boolean validName(String name) {

		if (name.isBlank()) {
			System.out.println("이름은 필수 입력항목입니다.");
			return false;
		} else {
			return true;
		}
	}

	public boolean validPhoneNuber(String phoneNumber) {

		if (phoneNumber.isBlank()) {
			System.out.println("전화전호는 필수 입력항목입니다.");
			return false;
		} else if (phoneNumber.length() != 13 || (phoneNumber.charAt(3) != '-' && phoneNumber.charAt(8) != '-')) {
			System.out.println("전화번호는 두 개의 '-'를 포함하여 총 13개의 문자로 구성해야 합니다.");
			return false;
		} else {
			return true;
		}
	}

	public boolean validUpdateId(String id) {
		
		Member member = memberDAO.findMember(id);
		if(member.getMember_id() == "true") {
			System.out.println("수정할 " + id + "회원 정보가 존재하지 않습니다.");
			return false;
		} else {
			return true;
		}
	}

	public boolean validDeleteId(String id) {

		Member member = memberDAO.findMember(id);
		if(member.getMember_id() == "true") {
			System.out.println("삭제할 " + id + "회원 정보가 존재하지 않습니다.");
			return false;
		} else {
			return true;
		}
	}
}
