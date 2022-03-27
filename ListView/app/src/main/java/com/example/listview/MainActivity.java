package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] listItems;
    ArrayList<SanPham> sanPhams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gv_traicay = findViewById(R.id.gridview_traicay);
//        listItems = getResources().getStringArray(R.array.traicay_array);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
        sanPhams = new ArrayList<>();
        addSanPham();
        MyArrayAdapter adapter = new MyArrayAdapter(this, R.layout.custom_gridview, sanPhams);

        gv_traicay.setAdapter(adapter);
        gv_traicay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, sanPhams.get(i)+"", Toast.LENGTH_SHORT).show();
                SanPham sanPham =   sanPhams.get(i);
                int hinh  = sanPham.getHinhAnh();
                double gia = sanPham.getGiaSanPham();
                String ten = sanPham.getTenSanPham();
                String mota = sanPham.getThongTinChiTiet();

                Intent intent = new Intent(MainActivity.this, Activity2.class);

                intent.putExtra("hinh", hinh);
                intent.putExtra("ten", ten);
                intent.putExtra("gia", gia);
                intent.putExtra("mota", mota);
                startActivity(intent);
            }
        });

    /*    ListView listView = findViewById(R.id.listview_traicay);
        //Laáy ra danh sách item trong string.xml
        listItems = getResources().getStringArray(R.array.traicay_array);
        //sử dụng Adapter để đưa danh sách item vào listview
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String st = listItems[i];
                Toast.makeText(MainActivity.this, st, Toast.LENGTH_LONG).show();

            }
        });*/
/*        Spinner spinner = findViewById(R.id.spinner_traicay);
        //Laáy ra danh sách item trong string.xml
        listItems = getResources().getStringArray(R.array.traicay_array);
        //sử dụng Adapter để đưa danh sách item vào listview
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String st = listItems[i];
                Toast.makeText(MainActivity.this, st, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
    }

    private void addSanPham(){
        sanPhams.add(new SanPham(1,"Vinamilk", R.drawable.vinamilk, 6900,"Thương hiệu: " + "Vinamilk\n" +
                "Xuất xứ: " + "Việt Nam\n" +
                "Hạn sử dụng: " + "6 tháng\n" +
                "Thể tích: " + "220ml\n" +
                "Kho hàng: " + "998\n" +
                "Gửi từ: " + "Quận Cẩm Lệ, Đà Nẵng\n"+
                "Giúp tăng cường thị lực và có một hệ xương thật chắc khỏe\n" +
                "Hương vị thơm ngon, đa dạng cho cả gia đình nhiều sự lựa chọn hấp dẫn\n" +
                "Giàu dưỡng chất, tiện dụng với mức giá vô cùng hợp lý\n" +
                "Sữa bịch Vinamilk không chỉ là nguồn dưỡng chất thiết yếu mà còn thật tiết kiệm, giúp bạn và gia đình thưởng thức cuộc sống tươi đẹp trọn vẹn."));
        sanPhams.add(new SanPham(2,"Aquatina", R.drawable.aquatina, 5000,"Hương vị : nước tinh khiết. Khai thác từ nguồn nước ngầm chất lượng cao. Dùng để giải khát, bổ sung nước. Giúp điều chỉnh nhiệt độ cơ thể\n" +
                "Sản xuất tại : Việt Nam\n" +
                "Aquafina là nhãn hiệu của công ty PepsiCo\n" +
                "Dung tích 1.5l"+
                "Thành phần và công dụng: " +
                "Nước tinh khiết Aquafina là nước tinh khiết được xử lý qua hệ thống thẩm thấu ngược và ozon, thanh trùng bằng tia cực tím. Được khai thác và đóng chai trên dây chuyền công nghệ hiện đại, đảm bảo giữ độ tinh khiết cao mà vẫn chứa các khoáng chất tốt cho sức khỏe. Sản phẩm đóng chai tiện lợi, giúp bạn bổ sung nước và khoáng chất nhanh chóng.\n" +
                "Hướng dẫn sử dụng: Dùng trực tiếp, ngon hơn khi uống lạnh.\n" +
                "Bảo quản: Để nơi khô ráo, thoáng mát, tránh ánh năng trực tiếp."));
        sanPhams.add(new SanPham(3,"Lavie", R.drawable.lavie, 7000,"Thương hiệu: LaVie\n" +
                "Loại nước: Nước khoáng\n" +
                "Xuất xứ: Việt Nam\n" +
                "Trọng lượng: 1kg\n" +
                "Hạn sử dụng: 23 tháng\n" +
                "Ngày hết hạn: 01-05-2023\n" +
                "Thể tích: 1.5L\n" +
                "Thành phần: nước\n" +
                "Số lượng: 1\n" +
                "Sản xuất tại: Việt Nam.\n" +
                "Hướng dẫn sử dụng: Dùng trực tiếp, ngon hơn khi uống lạnh.\n" +
                "Hướng dẫn bảo quản:\n" +
                "\t- Bảo quản nơi sạch sẽ, khô ráo thoáng mát.\n" +
                "\t- Tránh ánh nắng mặt trời.\n" +
                "\t- Tránh bị đông đá."));

        sanPhams.add(new SanPham(4,"Pepsi", R.drawable.pepsi, 9000,"Xuất xứ: Việt Nam\n" +
                "Thương hiệu: Pepsi\n" +
                "Pepsi là nhãn hiệu nước giải khát hương Cola có gas nổi tiếng toàn cầu, được kế thừa nhiều giá trị lịch sử lâu đời. Tại Việt Nam, tự hào là một nhãn hàng đại diện cho tiếng nói của giới trẻ cùng với thông điệp “CỨ TRẺ, CỨ CHẤT, CỨ PEPSI”, chúng tôi luôn tìm cách mang đến lại những trải nghiệm sảng khoái tột đỉnh, khuyến khích người trẻ nắm bắt và tận hưởng từng khoảnh khắc thú vị của cuộc sống." +
                " Nước Ngọt Có Gaz Pepsi với hương cola hấp dẫn, mang lại cảm giác sảng khoái, giải nhiệt tức thì trong những ngày nóng bức. Dùng trực tiếp, sẽ ngon hơn khi ướp lạnh, hoặc dùng với đá." +
                "\n" +
                "HƯỚNG DẪN SỬ DỤNG:\n" +
                "\t" + "Dùng ngay sau khi mở nắp. Ngon hơn khi uống lạnh.\n" +
                "BẢO QUẢN:\n" +
                "\t" + "Để nơi khô ráo, thoáng mát, tránh ánh sáng trực tiếp hoặc nơi có nhiệt độ cao.\n" +
                "HẠN SỬ DỤNG:\n" +
                "\t" + "NSX: xem trên bao bì.\n" +
                "\t" + "HSD: 12 tháng kể từ ngày sản xuất.\n" +
                "Không sử dụng sản phẩm quá hạn sử dụng."));
        sanPhams.add(new SanPham(5,"Vaseline", R.drawable.vaseline, 139000,"Dung tích: 320ml\n" +
                "Trọng lượng đóng gói: 420g\n" +
                "Xuất xứ: Thái Lan\n" +
                "Thương hiệu: Vaseline\n" +
                "Sữa Dưỡng Thể Trắng Da VASELINE 50X SPF 50+ THÁI LAN 320ml\n" +
                "\n" +
                "Công Dụng\n" +
                "Sữa dưỡng thể Vaseline 50X SPF 50+ PA++++ được tích hợp cùng lúc nhiều chức năng bên trong một chất kem, mang lại tác dụng dưỡng trắng gấp 50 lần so với các dòng dưỡng Vaseline thường. Vaseline Healthy White 50X với công thức giàu hàm lượng Vitamin B3 giúp dưỡng trắng da, giảm vết thâm, làm đều màu da mang lại cho bạn làn da trắng sáng rực rỡ, da nhanh chóng lên tone và mịn màng. \n" +
                "Không chỉ có tác dụng dưỡng trắng da như các sản phẩm thông thường, tinh chất Vaseline Healthy White Sun + Pollution Protection 50X còn có chức năng bảo vệ làn da trước tác động xấu của môi trường ô nhiễm ngăn chặn sự xâm nhập của các chất độc hại, cùng với đó là bảo vệ làn da khỏi tác hại từ ánh nắng mặt trời, chống nắng vượt trội nhờ vào màng chống nắng 3 tác động. Với chỉ số chống SPF 50+ PA++++ giúp chống nắng và bảo vệ da khỏi tác hại của cả tia UVA và UVB. \n" +
                "Tính năng thẩm thấu vượt trội giúp da hấp thu 100% dưỡng chất vào da, bổ sung dưỡng chất nuôi dưỡng da giúp phục hồi hư tổn và tái tạo làn da từ sâu bên trong.\n" +
                "Cung cấp độ ẩm cần thiết để duy trì làn da luôn được mịn màng và săn chắc, làm cho da rạng rỡ, đầy sức sống"));
        sanPhams.add(new SanPham(6,"Bia Sài Gòn", R.drawable.biasaigon, 11900,"Thương hiệu: BIA SAIGON\n" +
                "Hàm Lượng cồn: 5%\n" +
                "Thể tích: 330ml\n" +
                "Dòng bia: Lager\n" +
                "Hạn sử dụng: 9 tháng\n"+
                "Chủng loại sản phẩm: Bia Lager.\n" +
                "Thành phần: Nước, malt đại mạch, hoa bia.\n" +
                "Bao bì: Đóng trong lon nhôm, 18 lon/thùng carton \n" +
                "Hướng dẫn sử dụng: Ngon hơn khi uống lạnh, tốt nhất ở 10 – 15 độ C.\n" +
                "Hướng dẫn bảo quản:\n" +
                "\t+ Bảo quản nơi khô ráo và thoáng mát. \n" +
                "\t+ Tránh tiếp xúc trực tiếp với nguồn nóng hoặc ánh sáng mặt trời. "));
        sanPhams.add(new SanPham(7, "TH TRUE TEA",R.drawable.tea_thtrue, 7000,"Thương hiệu: TH true milk\n" +
                "Dạng đồ uống: Pha sẵn\n" +
                "Xuất xứ: Việt Nam\n" +
                "Hương vị: Trà xanh\n" +
                "Loại thực phẩm: Khác\n" +
                "Trọng lượng: 2kg\n" +
                "Ngày hết hạn: 28-07-2022\n" +
                "Thể tích: 350ml\n" +
                "Hạn sử dụng: 8 tháng\n" +
                "Thành phần: Lá trà xanh\n" +
                "Số lượng: 1\n" +
                "Kích Cỡ Gói: 2KG"+
                "\n• Nguyên liệu chính để sản xuất trà xanh vị chanh tự nhiên : lá trà shan tuyết tuyển chọn từ cao nguyên hà gian - vùng nguyên liệu trà nổi tiếng ở độ cao trên 700m\n" +
                "• Nguyên liệu hoàn toàn tự nhiên.không phụ gia tổng hợp, không chất bảo quản\n" +
                "• cổ chai rộng mang đến trải nghiệm uống sảng khoái "));
        sanPhams.add(new SanPham(8, "Nước mắm Nam Ngư",R.drawable.nuoc_mam_nam_ngu ,46000, "Xuất xứ: Công Ty LD CBTP VITECFOOD\n" +
                "\n" +
                "Thành phần: Nước, muối, đạm cá cơm, đường, chất điều vị, chất bảo quản, sodium benzoate, urê nội sinh dưới 0.025%, chất ổn định, màu tổng hợp, màu caramen, hương cá hồi…\n" +
                "\n" +
                "Quy cách: 900ml/Chai\n" +
                "\n" +
                "Đơn vị tính: Chai\n" +
                "\n" +
                "Sử dụng: Dùng để chấm, nêm, nấu hay tẩm ướp với nhiều món ăn.\n" +
                "\n" +
                "Bảo quản: Bảo quản nơi khô ráo, thoáng mát, tránh ánh nắng trực tiếp."));
        sanPhams.add(new SanPham(9,"Bánh Ngũ Cốc Ăn Sáng Weetabix", R.drawable.weetabix, 1694000, "Nhà cung cấp: Csfood\n" +
                "Thương hiệu: Weetabix\n" +
                "Xuất xứ: Anh\n"+
                "Thành phần: lúa mì nguyên hạt, chiết xuất từ mạch nha- lúa mạch, đường, muối\n" +
                "Quy cách: hộp 430g x thùng 14 hộp\n" +
                "Đơn vị tính: thùng\n" +
                "Sử dụng: dùng trực tiếp\n" +
                "Bảo quản: ở nhiệt độ thoáng mát, tránh ánh nắng trực tiếp."));
        sanPhams.add(new SanPham(9,"Bột bánh cuốn", R.drawable.bot_banh_cuon, 17400, "Xuất xứ: Công Ty Cổ Phần Bột Thực Phẩm Tài Ký\n"+
                "Thành phần: Bột gạo, tinh bột khoai mì.\n" +
                "Quy cách: 400g\n" +
                "Đơn vị tính: Gói\n" +
                "Sử dụng: dùng chế biến món ăn\n" +
                "Bảo quản: Nơi khô ráo, thoáng mát, tránh ánh nắng mặt trời\n"+
                "Cách dùng sản phẩm:\n" +
                "\tBước 1: pha bột bánh cuốn 400g + 1 lít nước + 1 thìa dầu ăn.\n" +
                "\tBước 2: làm nhân bánh gồm có thịt nạc, hành tây, nấm mèo bâm nhỏ xào chín.\n" +
                "\tBước 3: tráng bánh – cho bột vào chảo chống dính, tráng mỏng, đậy nắp 15 giây, lấy bánh bằng cách úp chảo xuống măm có thoa dầu.\n" +
                "\tBước 4: Cho nhân vào giữa bánh và cuốn bánh lại, bánh dùng với giá trụng, rau thơm cắt nhỏ, hành phi, chả lụa và nước mắm pha."));
        sanPhams.add(new SanPham(10, "Bánh quy Olak", R.drawable.banh_quy_olak,80000,"Xuất xứ: Công Ty TNHH Thực Phẩm Kim Hùng\n" +
                "Thành phần: Bột mì, đường, chất béo thực vật, sữa bột, bơn trứng, muối, chất tạo nhũ, vani, hương sữa, hương hoa quả…\n" +
                "Quy cách: 360g/Hộp\n" +
                "Đơn vị tính: Hộp\n" +
                "Sử dụng: Ăn trực tiếp\n" +
                "Bảo quản: Bảo quản nơi khô ráo, thoáng mát, sạch sẽ, tránh ánh nắng trực tiếp"));
    }
}