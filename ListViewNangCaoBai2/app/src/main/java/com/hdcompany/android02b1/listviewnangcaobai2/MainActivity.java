package com.hdcompany.android02b1.listviewnangcaobai2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.hdcompany.android02b1.listviewnangcaobai2.adapter.FlagsAdapter;
import com.hdcompany.android02b1.listviewnangcaobai2.model.Flag;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edt_1, edt_2;
    Button btn_update, btn_view, btn_add;

    String tamThoi, name, money;

    ListView lv_flag;
    ArrayList<Flag> arrFlag = new ArrayList<>();
    FlagsAdapter flagsAdapter;

    int viTri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        anhXa();
        xyLy();


    }


    private void themDuLieu() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edt_1.getText().toString();
                arrFlag.add(new Flag(name, money, R.drawable.icon_achen));
                Toast.makeText(MainActivity.this, "Thêm thành công: " + name, Toast.LENGTH_SHORT).show();
                flagsAdapter.notifyDataSetChanged();
            }
        });
    }

    private void clickItem() {
        lv_flag.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edt_1.setText(arrFlag.get(position).getFlag_name());
                edt_2.setText(arrFlag.get(position).getMoney());
                viTri = position;
            }
        });
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edt_1.getText().toString();
                money = edt_2.getText().toString();
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("1", name);
                bundle.putString("2", money);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void delete() {
        lv_flag.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                tamThoi = arrFlag.get(position).getFlag_name().toString();


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo");

                builder.setMessage("Bạn có chắc chắn muốn xóa không?");

                // Nút "Có"
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrFlag.remove(position);
                        Toast.makeText(MainActivity.this, "Xóa thành công: " + tamThoi, Toast.LENGTH_SHORT).show();
                        flagsAdapter.notifyDataSetChanged();
                    }
                });

                // Nút "Không"
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(MainActivity.this, "Không xóa", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                return false;
            }

        });
    }

    private void update() {

        lv_flag.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edt_1.setText(arrFlag.get(position).getFlag_name());
                edt_2.setText(arrFlag.get(position).getMoney());
                viTri = position;
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrFlag.set(viTri, new Flag(edt_1.getText().toString(), edt_2.getText().toString()));
                Toast.makeText(MainActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                flagsAdapter.notifyDataSetChanged();

            }
        });
    }

    private void xyLy() {

        arrFlag.add(new Flag("Brazil", "Don't know", R.drawable.icon_bra));
        arrFlag.add(new Flag("Argentina", "Don't know", R.drawable.icon_achen));
        arrFlag.add(new Flag("Canada", "Don't know", R.drawable.icon_cana));
        arrFlag.add(new Flag("Australia", "Don't know", R.drawable.icon_uc));
        flagsAdapter = new FlagsAdapter(this, R.layout.item_flag, arrFlag);
        lv_flag.setAdapter(flagsAdapter);

        update();
        delete();
        clickItem();
    }


    private void anhXa() {

        edt_1 = findViewById(R.id.edt_1);
        edt_2 = findViewById(R.id.edt_2);
        btn_add = findViewById(R.id.btn_add);
        btn_update = findViewById(R.id.btn_update);
        btn_view = findViewById(R.id.btn_view);
        lv_flag = findViewById(R.id.lv_flag);


    }
}