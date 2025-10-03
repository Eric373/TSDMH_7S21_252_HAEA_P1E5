package mx.edu.tesoem.isc.tsdmh_7s21_252_haea_p1e5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrincipalActivity extends AppCompatActivity {

    Button btn1p1;

    TextView txtnombre;

    ActivityResultLauncher<Intent> ActividadResultado = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {

    if (result.getResultCode() == RESULT_OK){

        String cadena = result.getData().getStringExtra("saludo");
        Toast.makeText(this, "Bienvenido "+cadena, Toast.LENGTH_LONG).show();

    }else {

        Toast.makeText(this, "Se cancelo por el usuario", Toast.LENGTH_SHORT).show();

    }

    } );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtnombre = findViewById(R.id.txtnombre);
        btn1p1 = findViewById(R.id.btn1p1);

        btn1p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrincipalActivity.this, ConfirmaActivity.class);
                intent.putExtra("nombre", txtnombre.getText().toString());
                ActividadResultado.launch(intent);
            }
        });

    }
}