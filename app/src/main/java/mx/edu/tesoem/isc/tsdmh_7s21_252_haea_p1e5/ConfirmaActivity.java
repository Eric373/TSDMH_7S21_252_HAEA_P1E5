package mx.edu.tesoem.isc.tsdmh_7s21_252_haea_p1e5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmaActivity extends AppCompatActivity {

    Button btn1p2, btn2p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirma);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn1p2 = findViewById(R.id.btn1p2);
        btn2p2 = findViewById(R.id.btn2p2);

        Bundle datos = getIntent().getExtras();
        String cadena = datos.getString("nombre");
        Intent intent = new Intent();
        intent.putExtra("saludo", cadena);

        btn1p2.setOnClickListener(v -> {

        setResult(RESULT_OK, intent);
        finish();

        });

        btn2p2.setOnClickListener(v -> {

            setResult(RESULT_CANCELED);
            finish();

        });

    }
}