package br.edu.ifpb.atividadecolaborativa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by Edilva on 06/04/2018.
 */

public class Sair {

    private Context context;

    public Sair(Context context) {
        this.context = context;
    }

    public void sair() {
        /*SharedPreferences save = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor saveEdit = save.edit();
        saveEdit.clear();
        saveEdit.commit();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);*/

        Intent  it = new Intent(context.getApplicationContext(), MainActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        it.putExtra("SAIR", true);
        context.startActivity(it);
    }
}
