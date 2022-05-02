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

				System.out.print("아이디를 입력하세요 (형식 M-00001) : ");
				member.setMember_id(br.readLine());
				System.out.print("이름을 입력하세요 : ");
				member.setName(br.readLine());
				System.out.print("전화번호를 입력하세요 : ");
				member.setPhone_number(br.readLine());
				memberDAO.insertMember(member);
				System.out.println("---> 회원가입에 성공하셨습니다.");
				break;
			}
			case 3: {
				Member member = new Member();
				
				System.out.print("수정할 아이디를 입력하세요 (형식 M-00001) : ");
				member.setMember_id(br.readLine());
				System.out.print("수정할 전화번호를 입력하세요 : ");
				member.setPhone_number(br.readLine());
				memberDAO.updateMember(member);
				System.out.println("---> 회원수정에 성공하셨습니다.");
				break;
			}
			case 4: {
				Member member = new Member();
				
				System.out.print("삭제할 아이디를 입력하세요 (형식 M-00001) : ");
				member.setMember_id(br.readLine());
				memberDAO.deleteMember(member);
				System.out.println("---> "+ member.getMember_id() + "회원 삭제에 성공하셨습니다.");
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

}
