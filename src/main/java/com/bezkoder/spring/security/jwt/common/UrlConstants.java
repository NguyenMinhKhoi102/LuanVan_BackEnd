package com.bezkoder.spring.security.jwt.common;

public class UrlConstants {

    //ROOT
    public static final String ROOT = "/api";

    //CRUD
    public static final String INFO = "/info";
    public static final String LIST = "/list";
    public static final String ADD = "/add";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";

    //different
    public static final String ACTIVE = "/active";

    //Hồ sơ đính kèm
    public static final String HO_SO_DINH_KEM = ROOT + "/attached-file";

    //Thành viên cùng thay đổi
    public static final String THANH_VIEN_CUNG_THAY_DOI = ROOT + "/member-change-together";

    //Loại hồ sơ
    public static final String LOAI_HO_SO = ROOT + "/type-profile";

    //Loại thông báo
    public static final String LOAI_THONG_BAO = ROOT + "/type-notification";

    //Hình thức nhận kết quả
    public static final String HINH_THUC_NHAN_KET_QUA = ROOT + "/receive-result";

    //Hồ sơ chung
    public static final String HO_SO_CHUNG = ROOT + "/general-profile";

    //Hồ sơ tạm trú
    public static final String HO_SO_TAM_TRU = ROOT + "/temporary-residence-profile";

}
