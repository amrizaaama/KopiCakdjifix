package org.aplas.kopicakdji;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txtJumlah, txtHarga, txtGetNama;
    private EditText edtNama;
    private RadioGroup rgMenu;

    private int jumlah = 0, total = 0, hargaKopi = 6000, hargaSusu = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtJumlah = findViewById(R.id.txt_jumlah);
        txtHarga = findViewById(R.id.txt_price);
        txtGetNama = findViewById(R.id.txt_getNama);
        edtNama = findViewById(R.id.txt_nama);
        rgMenu = findViewById(R.id.menu);
    }

    public void tambah(View view) {
        jumlah++;
        txtJumlah.setText(String.valueOf(jumlah));
    }

    public void kurang(View view) {
        if (jumlah >= 1) {
            jumlah--;
            txtJumlah.setText(String.valueOf(jumlah));
        }
    }

    public void order(View view) {
        display();
    }

    public void display(){
        //check pilihan di radio button
        int selected_rb = rgMenu.getCheckedRadioButtonId();

        switch (selected_rb) {
            case R.id.cbx_kopi :
                total = hargaKopi*jumlah;
                break;
            case R.id.cbx_Susu :
                total = hargaSusu*jumlah;
                break;
        }

        //display harga dan nama
        txtGetNama.setText(edtNama.getText());
        txtHarga.setText("Total : Rp. " + total);
    }
}