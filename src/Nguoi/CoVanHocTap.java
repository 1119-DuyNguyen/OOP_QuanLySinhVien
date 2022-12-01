package Nguoi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import DanhSach.DSLop;

public class CoVanHocTap extends Nguoi implements ActionMemberClassroom {
	private String maCVHT;
	private static int createdMaCVHT = 1;// mặc định có 2 cvht
	static {
		// Khởi tạo data
		File file = new File("data/maCVHT.txt");
		if (!file.exists()) {
			try {
				// khởi tạo mẫu
				file.createNewFile();
				CoVanHocTap.writeFileCurrentMaCVHT(createdMaCVHT);

			} catch (IOException e) {

				e.printStackTrace();
			}
		} else {
			readFileCurrentMaCVHT();
		}
	}

	public CoVanHocTap() {
		super();
		CoVanHocTap.writeFileCurrentMaCVHT(createdMaCVHT + 1);
		this.maCVHT = Integer.toString(createdMaCVHT);

	}

	public CoVanHocTap(String maCVHT, String hoTen, String gioiTinh, String soDt, String diaChi) {
		super(hoTen, gioiTinh, soDt, diaChi);
		this.maCVHT = maCVHT;
	}

	public String getMaCVHT() {
		return maCVHT;
	}

	@Override
	public void xemLop() {
		// TODO Auto-generated method stub
		System.out.println("Các lớp cố vấn quản lý là :");
		DSLop dsLop = new DSLop();
		dsLop.xuatDSTheoMaCoVan(this.maCVHT);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String parentString = super.toString();

		return String.format("%-20s|%s", this.maCVHT, parentString);
	}

	public static void showMenu() {
		System.out.println("\n-----------Sửa thông tin-----------");
		System.out.println("0. Quay lại");
		System.out.println("1. Sửa họ tên");
		System.out.println("2. Sửa giới tính");
		System.out.println("3. Sửa số điện thoại");
		System.out.println("4. Sửa địa chỉ");
		System.out.println("5. Sửa tất cả thông tin");
		System.out.println("---------------------------");
	}

	public void suaThongTin() {
		int chon = 0;
		do {
			showMenu();
			System.out.print("Nhập lựa chọn: ");
			try {
				chon = Integer.parseInt(sc.nextLine());
				switch (chon) {
				case 0:
					break;
				case 1:
					System.out.print("Nhập họ tên: ");
					setHoTen(sc.nextLine());
					break;
				case 2:
					System.out.print("Nhập giới tính: ");
					setGioiTinh();
					break;
				case 3:

					System.out.print("Nhập số điện thoại: ");
					setSoDt(sc.nextLine());
					break;
				case 4:
					System.out.print("Nhập địa chỉ: ");
					setDiaChi(sc.nextLine());
					break;
				case 5:
					System.out.print("Nhập họ tên: ");
					setHoTen(sc.nextLine());
					System.out.print("Nhập giới tính: ");
					setGioiTinh();
					System.out.print("Nhập số điện thoại: ");
					setSoDt(sc.nextLine());
					System.out.print("Nhập địa chỉ: ");
					setDiaChi(sc.nextLine());
					break;
				default:
					System.out.println("Lựa chọn không hợp lệ ! Hãy chọn lại");
					break;
				}
			} catch (Exception e) {
				System.out.println("Lựa chọn không hợp lệ ! Hãy chọn lại");
			}
		} while (chon <= 5 && chon > 0);

	}

	public void xuatThongTin() {
		String formatString = String.format("%-20s|%s", maCVHT, super.toString());
		System.out.println(formatString);
	}

	// đọc file
	private static void readFileCurrentMaCVHT() {
		FileReader fReader;
		try {
			fReader = new FileReader("data/maCVHT.txt");

			BufferedReader bufferreader = new BufferedReader(fReader);
			CoVanHocTap.createdMaCVHT = Integer.parseInt(bufferreader.readLine());

			bufferreader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ghi file
	public static void writeFileCurrentMaCVHT(int createdMaCVHT) {
		CoVanHocTap.createdMaCVHT = createdMaCVHT;
		FileWriter fw;
		try {
			fw = new FileWriter("data/maCVHT.txt");

			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(Integer.toString(createdMaCVHT));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
