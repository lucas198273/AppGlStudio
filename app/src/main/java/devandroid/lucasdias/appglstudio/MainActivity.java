package devandroid.lucasdias.appglstudio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

import devandroid.lucasdias.appglstudio.controller.AgendamentoController;
import devandroid.lucasdias.appglstudio.model.AgendamentoConfirmado;

public class MainActivity extends AppCompatActivity {



    AgendamentoController controller;



    EditText nomeCompleto;
    EditText telefone;
    EditText tipoServico;
    Button btFinalizar;
    Button btLimpar;
    AgendamentoConfirmado agendamentoUsuario;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.agendamento_user);

    agendamentoUsuario = new AgendamentoConfirmado();
    controller = new AgendamentoController(MainActivity.this);
    agendamentoUsuario = controller.buscar(agendamentoUsuario);

        nomeCompleto = findViewById(R.id.edit_nome_completo);
        telefone = findViewById(R.id.edit_telefone);
        tipoServico = findViewById(R.id.edit_tipo_servico);
        btFinalizar = findViewById(R.id.btLogin);
        btLimpar = findViewById(R.id.btLimpar);

        nomeCompleto.setText(agendamentoUsuario.getNomeDoUsuario());



        nomeCompleto.setText(agendamentoUsuario.getNomeDoUsuario());
        telefone.setText(agendamentoUsuario.getTelefoneContato());
        tipoServico.setText(agendamentoUsuario.getTipoServico());


        btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                agendamentoUsuario.setNomeCompleto(nomeCompleto.getText().toString());
                agendamentoUsuario.setTelefoneContato(telefone.getText().toString());
                agendamentoUsuario.setTipoServico(tipoServico.getText().toString());

                Toast.makeText(MainActivity.this,"Cadastro realizado "+agendamentoUsuario.getNomeDoUsuario(),Toast.LENGTH_LONG).show();
                /*finish();*/
                controller.salvar(agendamentoUsuario);



            }
        });





         

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomeCompleto.setText("");
                telefone.setText("");
                tipoServico.setText("");
                controller.limpar();



            }
        });



    }

}