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

				System.out.print("���̵� �Է��ϼ���(���� M-00001) : ");
				msg = br.readLine();
				if (validId(msg)) {
					member.setMember_id(msg);
				} else {
					break;
				}
				System.out.print("�̸��� �Է��ϼ��� : ");
				msg = br.readLine();
				if (validName(msg)) {
					member.setName(msg);
				} else {
					break;
				}
				System.out.print("��ȭ��ȣ�� �Է��ϼ��� : ");
				msg = br.readLine();
				if (validPhoneNuber(msg)) {
					member.setPhone_number(msg);
				} else {
					break;
				}
				memberDAO.insertMember(member);
				System.out.println("---> ȸ�����Կ� �����ϼ̽��ϴ�.");
				break;
			}
			case 3: {
				Member member = new Member();
				String msg;

				System.out.print("������ ���̵� �Է��ϼ���(���� M-00001) : ");
				msg = br.readLine();
				if(validUpdateId(msg)) {
					member.setMember_id(msg);					
				} else {
					break;
				}
				System.out.print("������ ��ȭ��ȣ�� �Է��ϼ��� : ");
				msg = br.readLine();
				if(validPhoneNuber(msg)) {
					member.setPhone_number(msg);					
				} else {
					break;
				}
				memberDAO.updateMember(member);
				System.out.println("---> ȸ�������� �����ϼ̽��ϴ�.");
				break;
			}
			case 4: {
				Member member = new Member();
				String msg;
				
				System.out.print("������ ���̵� �Է��ϼ���(���� M-00001) : ");
				msg = br.readLine();
				if(validDeleteId(msg)) {
					member.setMember_id(msg);					
				} else {
					break;
				}
				memberDAO.deleteMember(member);
				System.out.println("---> " + member.getMember_id() + "ȸ�� ������ �����ϼ̽��ϴ�.");
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

	public boolean validId(String id) {

		Member member = memberDAO.findMember(id);
		if (id.isBlank()) {
			System.out.println("���̵�� �ʼ� �Է��׸��Դϴ�.");
			return false;
		} else if (id.charAt(0) != 'M' || id.length() != 7) {
			System.out.println("���̵�� 'M-'�� �����ؾ� �ϸ�, M-�� �����Ͽ� 7���� ���ڷ� �����ؾ� �մϴ�.");
			return false;
		} else if (member.getMember_id() == "true") {
			return true;
		} else {
			System.out.println(id + "�� �̹� �����մϴ�.");
			return false;
		}
	}

	public boolean validName(String name) {

		if (name.isBlank()) {
			System.out.println("�̸��� �ʼ� �Է��׸��Դϴ�.");
			return false;
		} else {
			return true;
		}
	}

	public boolean validPhoneNuber(String phoneNumber) {

		if (phoneNumber.isBlank()) {
			System.out.println("��ȭ��ȣ�� �ʼ� �Է��׸��Դϴ�.");
			return false;
		} else if (phoneNumber.length() != 13 || (phoneNumber.charAt(3) != '-' && phoneNumber.charAt(8) != '-')) {
			System.out.println("��ȭ��ȣ�� �� ���� '-'�� �����Ͽ� �� 13���� ���ڷ� �����ؾ� �մϴ�.");
			return false;
		} else {
			return true;
		}
	}

	public boolean validUpdateId(String id) {
		
		Member member = memberDAO.findMember(id);
		if(member.getMember_id() == "true") {
			System.out.println("������ " + id + "ȸ�� ������ �������� �ʽ��ϴ�.");
			return false;
		} else {
			return true;
		}
	}

	public boolean validDeleteId(String id) {

		Member member = memberDAO.findMember(id);
		if(member.getMember_id() == "true") {
			System.out.println("������ " + id + "ȸ�� ������ �������� �ʽ��ϴ�.");
			return false;
		} else {
			return true;
		}
	}
}
