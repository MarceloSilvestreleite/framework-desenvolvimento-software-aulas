package com.anhanguera.cadastroprodutos;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editPreco;
    private ListView listProdutos;
    private ProdutoDbHelper dbHelper;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        editPreco = findViewById(R.id.editPreco);
        listProdutos = findViewById(R.id.listProdutos);
        dbHelper = new ProdutoDbHelper(this);

        Button btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(v -> salvar());
        atualizarLista();
    }

    private void salvar() {
        String nome = editNome.getText().toString().trim();
        String precoStr = editPreco.getText().toString().trim();

        if (nome.length() < 3) {
            Toast.makeText(this,
                    "Nome inválido. Mínimo de 3 caracteres.",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        double preco;
        try {
            preco = Double.parseDouble(precoStr.replace(",", "."));
            if (preco <= 0) {
                Toast.makeText(this,
                        "Preço inválido. Informe um valor maior que zero.",
                        Toast.LENGTH_SHORT).show();
                return;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this,
                    "Preço inválido. Digite um número.",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        boolean sucesso = dbHelper.inserirProduto(nome, preco);
        if (sucesso) {
            Toast.makeText(this, "Produto salvo com sucesso!", Toast.LENGTH_SHORT).show();
            editNome.setText("");
            editPreco.setText("");
            atualizarLista();
        } else {
            Toast.makeText(this, "Erro ao salvar produto.", Toast.LENGTH_SHORT).show();
        }
    }

    private void atualizarLista() {
        List<String> itens = dbHelper.listarProdutos();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itens);
        listProdutos.setAdapter(adapter);
    }
}
