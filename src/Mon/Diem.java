package Mon;

import java.util.Scanner;

public class Diem {

	private float diemHe10;

	public Diem() {
	}

	public Diem(float diemHe10) {

		this.diemHe10 = diemHe10;
	}

	public float getDiemHe10() {
		return diemHe10;
	}

	public void setDiemHe10(float diemHe10) {
		this.diemHe10 = diemHe10;
	}

	public void nhapDiem() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập điểm: ");

		boolean isNotValid = true;
		do {
			try {
				float choice = Float.parseFloat(sc.nextLine());
				if (choice < 0f || choice > 10f) {
					System.out.println("Giá trị không hợp lệ! Vui lòng nhập lại");
				} else {
					isNotValid = false;
					this.diemHe10 = choice;
				}
			} catch (Exception e) {
				System.out.println("Giá trị không hợp lệ! Vui lòng nhập lại");
				// TODO: handle exception
			}

		} while (isNotValid);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%-4.2f", this.diemHe10);
	}
}

/*
 * void inTT(){
 * System.out.println("-----------------------------------------------");
 * System.out.println("Mã SV: "+getMaSv());
 * System.out.println("Mã MH: "+getMaMH());
 * System.out.println("Tên MH: "+getTenMh());
 * System.out.println("Số TC "+getSoTC());
 * System.out.println("Điểm: "+getDiem());
 * System.out.println("Tình Trạng: "+getTinhTrang());
 * System.out.println("-----------------------------------------------"); }
 */
