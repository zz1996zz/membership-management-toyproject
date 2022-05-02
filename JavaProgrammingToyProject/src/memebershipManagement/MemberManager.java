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

				System.out.print("���̵� �Է��ϼ��� (���� M-00001) : ");
				member.setMember_id(br.readLine());
				System.out.print("�̸��� �Է��ϼ��� : ");
				member.setName(br.readLine());
				System.out.print("��ȭ��ȣ�� �Է��ϼ��� : ");
				member.setPhone_number(br.readLine());
				memberDAO.insertMember(member);
				System.out.println("---> ȸ�����Կ� �����ϼ̽��ϴ�.");
				break;
			}
			case 3: {
				Member member = new Member();
				
				System.out.print("������ ���̵� �Է��ϼ��� (���� M-00001) : ");
				member.setMember_id(br.readLine());
				System.out.print("������ ��ȭ��ȣ�� �Է��ϼ��� : ");
				member.setPhone_number(br.readLine());
				memberDAO.updateMember(member);
				System.out.println("---> ȸ�������� �����ϼ̽��ϴ�.");
				break;
			}
			case 4: {
				Member member = new Member();
				
				System.out.print("������ ���̵� �Է��ϼ��� (���� M-00001) : ");
				member.setMember_id(br.readLine());
				memberDAO.deleteMember(member);
				System.out.println("---> "+ member.getMember_id() + "ȸ�� ������ �����ϼ̽��ϴ�.");
				break;
			}
			case 0: {
				k = false;
				break;
			}
			default:
				System.out.println("��ȣ�� �� �� �Է��ϼ̽��ϴ�.");
			}
		}
	}

	public void display() {

		System.out.println("����� ���Ͻø� 1���� �Է��ϼ���.");
		System.out.println("����� ���Ͻø� 2���� �Է��ϼ���.");
		System.out.println("������ ���Ͻø� 3���� �Է��ϼ���.");
		System.out.println("������ ���Ͻø� 4���� �Է��ϼ���.");
		System.out.println("���Ḧ ���Ͻø� 0���� �Է��ϼ���.");
	}

}
