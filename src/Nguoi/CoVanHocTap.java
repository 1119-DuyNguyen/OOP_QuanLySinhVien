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
		CoVanHocTap.writeFileCurrentMaCVHT(createdMaCVHT);
		this.maCVHT = Integer.toString(createdMaCVHT++);

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
