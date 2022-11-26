package trash;

import java.util.Scanner;

public class NienKhoa {
	private int namBatDauChuKy;
	private int namKetThucKetThucChuKy;

	// liên thông, vừa học vừa làm , chính quy
	private String heDaoTao;

	public int getNamBatDauChuKy() {
		return namBatDauChuKy;
	}

	public NienKhoa(int namBatDauChuKy, int namKetThucKetThucChuKy, String heDaoTao) {
		super();
		this.namBatDauChuKy = namBatDauChuKy;
		this.namKetThucKetThucChuKy = namKetThucKetThucChuKy;
		this.heDaoTao = heDaoTao;
	}

	public void setNamBatDauChuKy(int namBatDauChuKy) {
		this.namBatDauChuKy = namBatDauChuKy;
	}

	public int getNamKetThucKetThucChuKy() {
		return namKetThucKetThucChuKy;
	}

	public void setNamKetThucKetThucChuKy(int namKetThucKetThucChuKy) {
		this.namKetThucKetThucChuKy = namKetThucKetThucChuKy;
	}

	public String getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao() {
		Scanner scanner = new Scanner(System.in);
		String nhungHeDaoTao[] = { "Chính quy", "Vừa làm vừa học", "Liên Thông" };
		System.out.println("Nhập hệ đào tạo : ");

		for (int i = 0; i < nhungHeDaoTao.length; ++i) {
			System.out.println(i + "." + nhungHeDaoTao[i]);
		}
		do {
			int choice = Integer.parseInt(scanner.nextLine());
			if (choice >= 0 && choice < nhungHeDaoTao.length) {
				this.heDaoTao = nhungHeDaoTao[choice];
			} else {
				System.out.println("Nhập sai ! Vui lòng nhập lại");
			}
		} while (true);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%-20s|%-8s|%-8s", this.heDaoTao, this.namBatDauChuKy, this.namKetThucKetThucChuKy);
	}
}
