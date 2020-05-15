package app;

import java.util.Scanner;

public class DSSV{
    private SinhVien mangSinhVien[];
    private int siSo;
    Scanner scan = new Scanner(System.in);
    public DSSV(){
        this.mangSinhVien = new SinhVien [100];
        this.siSo = 0;
    }

    public void nhapDSSV(){
        System.out.println("Nhap so luong sinh vien (<100)");
        this.siSo = Integer.parseInt(scan.nextLine());
        for(int i=0; i<this.siSo; i++){
            this.mangSinhVien[i].nhapSinhVien();
        }
    }

    public void them1SinhVien(){
        this.mangSinhVien[siSo].nhapSinhVien();
        this.siSo++;
    }
    
    public void them1SinhVien(SinhVien sv){
        this.mangSinhVien[siSo] = sv;
        this.siSo++;
    }
    
    public void danhSachSinhVien() {
    	for(int i=0; i<this.siSo; i++) {
    		System.out.println(mangSinhVien[i].toString());
    	}
    }
    
    public DSSV timKiemTheoTen(String ten) {
    	DSSV DSSVTimRa = new DSSV();
    	for(int i=0; i<this.siSo; i++) {
    		if(this.mangSinhVien[i].getten().equals(ten)) {
    			DSSVTimRa.them1SinhVien(mangSinhVien[i]);
    		}
    	}
    	return DSSVTimRa;
    }
    
    public boolean timKiemTheoMssv(String mssv) {
    	for(int i=0; i<this.siSo; i++) {
    		if(mangSinhVien[i].getmssv().equals(mssv))
    			return true;
    	}
    	return false;
    }
    
    public int timKiemTheoMSSV(String mssv) {
    	for(int i=0; i<this.siSo; i++) {
    		if(mangSinhVien[i].getmssv().equals(mssv))
    			return i;
    	}
    	return -1;
    }
    
    public boolean xoa(String mssv) {
    	int index = timKiemTheoMSSV(mssv);
    	if(index >=0 ) {
    		int i=index;
    		while(i<this.siSo) {
    			mangSinhVien[i]=mangSinhVien[++i];
    			this.siSo--;
    		}
    		return true;
    	}else
    		return false;
    }
}