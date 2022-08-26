import entity.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Application {
    public static void main(String[] args) {
//        playWithArrayList();
//        sortArrayListManuallly();
//        playWithSet();
        Student result = searchStudent("SE8888");
        if (result  != null ){      //!= null (chính là số 0, toạ độ đáy ram)
            result.showProfile();
        }
        else {
            System.out.println("NOT FOUND!!!");
        }

    }

    //XEM LẠI 7 VIÊN NGỌC RỒNG
    //HÀM SEARCH TRẢ VỀ 1 OBJECT
    //PHÁT biểu chính xác: hàm trả về tham đến object, toạ độ của vùng new Student, không new Student mới
    //Student x; //x là tên tẳt, tham chiếu, con trỏ trỏ new nào đó
                 // cần lưu 1 toạ độ new Student
    public static Student searchStudent(String id) {// Tên hàm là toạ độ 1 sv
                                             // Số di động để kết nối sv
        // hoặc ta tìm thấy, hoặc không
        // thấy trả về toạ độ new Student , không thấy trả về null
        List<Student> arr = new ArrayList() ;
        Student binh = new Student("SE9999","NGUYEN VAN BINH",2002,6);

        arr.add(new Student("SE8888","TRAN VAN AN",2004,9));
        arr.add(binh);

        // QUÉT QUA GIỎ, LÔI TỪNG CON TRỎ get(i),
        // lấy được toạ độ từng vùng new Student, hỏi id của sv (i) là mấy
        // coi có bằng id đưa vào tìm hok đúng thì... không thì...

        Student tmpStudent = arr.get(0);
//        String tmpId = tmpStudent.getId();
        String tmpId = arr.get(0).getId();
        //Về logic : if (tmpId == id đưa vào) return vị trí thứ (i)
        // Nhưng khốn nạn không so sánh được chuỗi

        if (tmpId.equalsIgnoreCase(id))
            return tmpStudent;  //như nhau vì đang lấy thẻ 0
        //thẻ 0 đầu tiên ra ngoài

        return null;
    }


    //Set là loại túi/giỏ hàng hiệu. Không chấp nhận trong giỏ có
    // nhiều hơn 1 con trỏ mà lại đi trỏ trùng vùng new
    // mỗi con trỏ trong giỏ, biến object trong giỏ chỉ trỏ duy nhất trong giỏ
    // Ngoài đời: SET: cách thống kê, liệt kê danh sách mỗi người xh đúng 1 lần
    //                 số khán giả, mỗi người đếm 1 lần thôi
    //            List: thống kê số lượt người xh, chấp nhận ai đó xh nhiều lần được đếm nhiều lần
    //            số vé đã bán, người sẽ mua nhiều vé, xem nhiều lần
    // Tree: Sắp xếp , theo 1 thứ tự nào đó, học sau
    // Nên khi chơi với SET nói chung vào và ra không biết chính xác được
    // khốn nạn không có hàm GET()
    // FOR EACH QUÉT HẾT GIỎ THOY
    public static void playWithSet(){
        Set<Student> arr = new HashSet<>();


        Student binh = new Student("SE99999","BINH LE",2003,4.9) ;
        arr.add(new Student("SE1234556","AN NGUYEN",2004,9));
        arr.add(binh);      // 1 con trỏ trong giỏ tro new BINH 4.9
        arr.add(binh);      // add trỏ vùng đấy, trỏ vùng new đã đang trỏ
        //xem có đúng 3 người hk
        arr.add(new Student("SE1234556","AN NGUYEN",2004,9));
        //NÓ KHÔNG QUAN TÂM CÓ TRÙNG INFO/DATA HAY KHÔNG MÀ CHỈ QUAN TÂM CÓ TRÙNG TOẠ ĐỘ HAY KHÔNG
        //NẾU TRÙNG TOẠ ĐỘ THÌ NÓ CHỈ LẤY 1 THÔI



        System.out.println("THE STUDENT LIST");
        for (Student x:
             arr) {
            x.showProfile();
        }
    }



    //ArrayList, Vector, HashSet,... Chỉ là những loại Túi/giỏ chứa
    // nhiều/linh hoạt các món đồ, y chang túi Doraemon, Thạch sanh
    // Gọi chung là Collection Framework ~ Nhóm đồ chơi giúp lưu trữ nhiều món đồ, bộ sưu tập
    // Phân cấp, chia nhóm ra, gồm Abstract và gồm cụ thể luôn!!1
    // Thao tác cất đồ, lấy đồ, loại bỏ 1 món khỏi túi, cần mở khoá
    // Dễ làm, tức là chấm gọi hành động!!! Khác mảng  [Vị-trí-mấy]
    // Mảng giống kệ sách, không đóng cửa kiếng luôn
    // Bản chất chung là chứa danh sách tham chiếu

    //Sắp xếp danh sách sinh viên trong cái túi!!!
    //Có 2 cách: tự sort = tay, tự đổi vị trí trỏ, vị trí thẻ bài
    //chơi đồ sort tự động, ai đó sẽ sort cho mình, mình không tự viết
    // dính đến interface, làm bài riêng !!!
    public static  void sortArrayListManuallly() {
        ArrayList<Student> arr = new ArrayList<>();
        //mua cái túi, bỏ thẻ bài vào, bỏ tham chiếu vào, biến con trỏ vào
        //dĩ nhiên cần con trỏ vùng new Student() đầu có sẵn bên ngoài
        // arr chính là danh sách bệnh nhân, BỆNH NHÂN nằm phòng điều trị

        Student binh = new Student("S124124","Nguyen van Binh",2002,6);
        arr.add(new Student("SE1234","An Nguyen",2004,2));   // add 1 toạ độ
        arr.add(binh); // vẫn là thảy toạ độ vùng new vào trong giỏ
        arr.add(binh);

        System.out.println("THE STUDENTS LIST");
        for (Student x:
             arr) {
            // x = từng con trỏ trong giỏ, bằng từng toạ độ có trong các thẻ bài thứ i , mỗi biến Student trong giỏ ghi toạ độ vùng new
            x.showProfile();
        }


        System.out.println("THE STUDENTS LIST PRINTED BY USING FOR I");
        for(int i = 0; i < arr.size() ; i++){
            arr.get(i).showProfile();
        }


        //TA XOÁ CON TRỎ KHỎI GI, loại bỏ 1 thẻ bài, xoá thật
        //vùng new Student() bị xoá hay không lệ thuộc vào CT MTĐT và việc chàng khác có trỏ hay không
        //mảng không làm được điều này, FIXED SỐ CON TRỎ
        arr.remove(2);

        System.out.println("THE STUDENTS LIST NEW");
        for (Student x:
                arr) {
            x.showProfile();
        }

        //2 SV AN BÌNH
        //SẮP XẾP TĂNG DẦN THEO ĐIỂM
        //CON TRỎ [0] ĐANG TRỎ AN 2
        //CON TRỎ [1] ĐANG TRỎ BÌNH 6
        // ĐẢO VỊ TRÍ TRỎ, CON TRỎ (0) PHẢI ĐƯỢC SET LẠI, TRỎ ĐẾN BÌNH
        // get() lấy con trỏ
        // set() thay đổi toạ độ trỏ của biến con trỏ
        Student tmp = arr.get(0) ;
                //tmp trỏ vào get(0), thẻ bài 0, trỏ An 2
        arr.set(0,arr.get(1));
        //con trỏ 0 nay lấy toạ độ đang nằm trong con trỏ 1

        arr.set(1,tmp);
        //con trỏ 1 nay lấy toạ độ đang nằm trong tmp
        System.out.println("THE STUDENTS LIST NEW after SORt");
        for (Student x:
                arr) {
            x.showProfile();
        }




    }




    public static void playWithArrayList() {
        Student[] arr = new Student[500] ;
        //arr là 1 cái túi chứa sẵn 500 chỗ, 500 món đồ có thể bỏ vô
        //món đồ phải đi mua, new, thảy vào
        //tên mảng chính là má mì, quản lí nhiều đồ, tên túi luôn


        List arr1 = new ArrayList(); // đựng lộn xộn đủ loại con trỏ
        //Đúng nghĩa túi Doraemon , món gì cũng đựng, đựng tham chiếu thoy nha
        //nhét được NhanVien, GiangVien, Animal, Dog, ...
        //KHÔNG DÙNG

        //Túi đựng đồng nhất chỉ lưu con trỏ Student
        List<Student> arr2 = new ArrayList() ; // Túi đựng đồng nhất 1 loại GENERIC
//        List<Student> arr1 = new ArrayList<>() ;
//        List<Student> arr1 = new ArrayList<Student>() ;
        //~~ 2 cách viết dưới tương đương trên
        //arr1 là cái túi chứa vô hạn chỗ, vô hạn con trỏ
        //nhét đồng nhất món đồ dễ chấm chung được, đa hình được

        //MỞ NGĂN TỦ; TÚI NHÉT ĐỒ VÔ
//        arr[i] = new Student(...); //mảng
//        arr.add(new Student(...)); //lưu con trỏ, new Student thoải mái
//        bên ngoài, vùng HEAP

        Student s1 = new Student("SE1234","Nguyen van An",2003,5);
        Student s2 = new Student("SE3456","Tran Van Be",2002,7);
        Student s3 = new Student("SE1234","Le Duc Cuong",2000,9);

        //2 chàng 1 nàng
        arr2.add(s1);// trỏ vùng new ArrayList,tủ có thêm 1 con trỏ, sinh ra 1 con trỏ
        arr2.add(s2);// Sinh ra thêm con trỏ nữa [1]
        arr2.add(s3);// add() vô tận, mảng [length -1] hết mức
                     // new cứ nằm HEAP, SV cứ ở nhà, CN cứ ở xưởng, BN cứ ở giường
        //add() mở khoá kéo, khoá dây, nhét đồ vô, nhét tham chiếu, thẻ bài
        //Sinh ra con trỏ
        arr2.add(s1); //add trùng nè
        //Set thì nó không báo lỗi, nhưng nó chỉ lấy 1 thôi ... đừng vội vã vào chi tiết
        //3 chàng 1 nàng

        arr2.add(new Student("SE9999999","CHIN PHAM",2002,9));
        //  NEW CỨ LÊN HEAP MÀ NẰM, BỆNH NHÂN CỨ Ở PHÒNG, TỚ NẰM THẺ BÀI
        // 1 CON TRỎ NỮA LẠI ĐƯỢC ADD VÀO

        //hỏi xem túi đang có bao nhiêu đồ
        //arr.length hỏi túi mà, hỏi má mì mà, tên mảng mà
        System.out.println("The bag has: " + arr2.size() + "item");
        //5 sv in ra, nhưng thực ra chỉ có 3 sv, do có người đếm trùng

        //in mọi người ra
        // tủ có gì , chứa bên trong 1 đống con trỏ
        //mảng : [i].showProfile()
        //Tủ ArrayList(con-trỏ1, con-trỏ2, con-trỏ3, con-trỏ4, ...nếu add() thêm
        //add() đẩy vào 1 con trỏ, toạ độ, thẻ bài
        //get(vị trí thẻ bài muốn lấy), trả về  toạ độ con trỏ thứ i
        //
        //[i] lấy được tham chiếu bạn thứ i
        //get(i) lấy được chỗ ngồi tham chiếu con trỏ thẻ bài thứ i
        //a, thẻ này trỏ bạn sv kia kìa

        //in bạn đầu tiên
        //arr[i].showProfile() phần tử đầu tiên của mảng
        Student x = arr2.get(0) ; // trả về toạ độ con trỏ thẻ bài bạn thứ 0
        // trả về toạ độ thì gán vào biến Student nắm vùng toạ độ khác là oke

        System.out.println("The Students list ");
        x.showProfile();

        //bạn 1 get (1), có toạ độ chấm luôn rồi ,thêm biến con trỏ làm gì

        arr2.get(1).showProfile(); // á đù trả về con trỏ , học 7 viên ngọc rồng rồi

        System.out.println("In VIP");
        for (Student a:
             arr2) {
            a.showProfile();
        }

        System.out.println("In VIP for");
        for(int i = 0; i < arr2.size(); i++){
            arr2.get(i).showProfile();
        }

        // Không chỉ có add(), get()
        // mà còn có hành động xoá, loại bỏ 1 thẻ bài, gạch tên
        // 1 người khỏi danh sách,
        // vùng new Student() bị mất hay không tuỳ vào mấy con trỏ trỏ nó
        // size() giảm liền, mảng thì không có , vì mảng nó fix cứng rồi
        // set() đảo con trỏ, trỏ sang vùng khác ( get() , set() xưa nay của các object)

    }


}
