package com.example.conversor_macro_divisas_beta;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1;
    private TextView tvresultdiv;

    double EUR, valor;
    String resultado, escrito;

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Se llama a las variables de la capa xml a java
        et1 = (EditText) findViewById(R.id.ET_CantidadEuros);
        tvresultdiv = (TextView) findViewById(R.id.TV_CD);
        spinner1 = (Spinner) findViewById(R.id.S_Divisa);

//se le anotan al spinner las variables que se van a usar
        String [] opciones = {"RPI", "BBD", "AGW", "TAU", "BTC", "PKD", "KFR", "AMG"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);

        }

    public void llenartabla () {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BaseDatos", null,
                1);
        SQLiteDatabase db = admin.getWritableDatabase();

        i = 1;

        while (i >= 1) {

            int codigoi = i;
            String id = String.valueOf(codigoi);

            String descripcion = textotablas(codigoi);

            String razon = String.valueOf(metodorazon(codigoi));

            ContentValues registro = new ContentValues();
            registro.put("codigo", id);
            registro.put("descripcion", descripcion);
            registro.put("razon", razon);

            db.insert("articulos", null, registro);
            db.close();

            if (i >= 9) {

                break;

            } else {
                i++;
            }

        }
    }


    public void calcular (View view) {

//se evita el uso del la variable et1 para evitar sobre escrituras en la variable inecesarias

        llenartabla();

        String valor1_String = et1.getText().toString();

//se convierte la nueva variable a double para tener mucha mas precicion de la cifra exacta

        double valor1_double = Double.parseDouble(valor1_String);
        String seleccion = spinner1.getSelectedItem().toString();

//se usa un switch para evitar el uso largo en memoria del if

        switch (seleccion) {

            // Case 1: ecuacion en caso de que se use la divisa de lingotes good delivery de platino 190
            case "RPI":

                if (valor1_double != 0) {

                    double Pt190GD;

                    EUR = 28981716630.8 * 12.4;
                    Pt190GD = valor1_double/EUR;

                    resultado = String.valueOf(Pt190GD);
                    tvresultdiv.setText(resultado);

                }
                else { msgtoast(); }

                break;

            // Case 2: encuacion en caso del uso de usar una bolsa con 12.4 kg (good delivery)
            // de diamantes de sangre
            case "BBD":

                if (valor1_double != 0) {

                    double BBDGD;

                    EUR = 4528394504.95  * 12.4;
                    BBDGD = valor1_double/EUR;

                    resultado = String.valueOf(BBDGD);
                    tvresultdiv.setText(resultado);

                }
                else { msgtoast(); }

                break;

            // Case 3: ecuacion en caso de usarse el pib promedio nominal mundial
            case "AGW":

                if (valor1_double != 0) {

                    double PPNM;

                    EUR = 82950900000000.0 / 190;
                    PPNM = valor1_double/EUR;

                    resultado = String.valueOf(PPNM);
                    tvresultdiv.setText(resultado);

                }
                else { msgtoast(); }

                break;

            // Case 4: ecuacion en caso de usarse toneladas de oro como medicion
            case "TAU":

                if (valor1_double != 0) {

                    double TO;

                    EUR = 1574.93 * 35274;
                    TO = valor1_double/EUR;

                    resultado = String.valueOf(TO);
                    tvresultdiv.setText(resultado);

                }
                else { msgtoast(); }

                break;

            // Case 5: ecuacion en caso de usarse el bitcoin como unidad de medicion
            case "BTC":

                if (valor1_double != 0) {

                    double BTCv;

                    BTCv = valor1_double/38406.9;

                    resultado = String.valueOf(BTCv);
                    tvresultdiv.setText(resultado);

                }
                else { msgtoast(); }

                break;

            // Case 6: ecuacion en caso de usarse el derivado del dinar, volviendo este un centimo,
            // como unidad de medicion
            case "PKD":

                if (valor1_double != 0) {

                    double PKDv;

                    PKDv = valor1_double/ 58.1878;
                    PKDv = PKDv*0.01;

                    resultado = String.valueOf(PKDv);
                    tvresultdiv.setText(resultado);

                }
                else { msgtoast(); }

                break;

            // Case 7: ecuacion en caso de usarse un kilo de francio como unidad de medida
            case "KFR":

                if (valor1_double != 0) {

                    double KFRv;

                    KFRv = valor1_double/ 4528394504950.05;

                    resultado = String.valueOf(KFRv);
                    tvresultdiv.setText(resultado);

                }
                else { msgtoast(); }

                break;

            // Case 8: ecuacion en caso de usarse un gramo de antimateria como unidad de medida
            case "AMG":

                if (valor1_double != 0) {

                    double GAMv;

                    EUR = 58869118313246480.0 / 1000;
                    GAMv = valor1_double/ EUR;

                    resultado = String.valueOf(GAMv);
                    tvresultdiv.setText(resultado);

                }
                else { msgtoast(); }

                break;

            // Case 9
            // Default case
            default:

                // Print statement corresponding case
                Toast.makeText(this, "hubo un error inesperado en la seleccion spinner switch",
                        Toast.LENGTH_LONG).show();
        }

    }

    public void saltodoc (View view) {

        Intent documentacion = new Intent(this, MainActivity2.class);
        startActivity(documentacion);

    }

    public void msgtoast () {

        Toast.makeText(this, "la cantidad introducida debe ser mayor a cero",
                Toast.LENGTH_LONG).show();

    }

/*    public void registrar () {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BD", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = etcodigo.gettext().Tostring();
        String descripcion = etdescripcion.gettext().Tostring();
        String precio = etprecio.gettext().Tostring();

        (!codigo.isEmpty() && descripcion.isEmpty() && precio.isEmpty()) {

            ContentValues registro = new ContentValues();
        registro.put("codigo", codigo);
        registro.put("descripcion", descripcion);
        registro.put("precio", precio);

            db.insert("articulos", null, registro);
            db.close();

        etcodigo.settext("");
        etdescripcion.settext("");
        etprecio.settext("");

        } else {

            Toast.makeText(this, "debes llenar todos los campos", Toast.LENGTH_SHORT).show();

        }

    }

    public void modificar () {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BD", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = etcodigo.gettext().Tostring();
        String descripcion = etdescripcion.gettext().Tostring();
        String precio = etprecio.gettext().Tostring();

        if (!codigo.isEmpty() && descripcion.isEmpty() && precio.isEmpty()) {

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);
//------------------------------------------------------------------------------------algo pasa aqui
            int cantidad = db.update("articulos", registro, "codigo=" + codigo, null);
            db.close();

            if (cantidad == 1){

                Toast.makeText(this, "el articulo esta modificado correctamente", Toast.LENGTH_SHORT).show();

            }
            else {
                Toast.makeText(this, "el articulo no existe", Toast.LENGTH_SHORT).show();
            }

            etcodigo.settext("");
            etdescripcion.settext("");
            etprecio.settext("");

        } else {

            Toast.makeText(this, "debes llenar todos los campos", Toast.LENGTH_SHORT).show();

        }

    }*/

    public String textotablas (int entero) {

        switch (entero) {

            // Case 1: ecuacion en caso de que se use la divisa de lingotes good delivery de platino 190
            case 1:

                escrito = "RPI por su abreviación en ingles Rare Platinum Ingot es una unidad de macro divisa " +
                        "basada en un lingote (Good Delivery) de platino 190 el cual se mide su conversión a " +
                        "euros mediate las variables:\n\n" +
                        "Double Pt190GD;\n" +
                        "EUR = 28981716630.8 * 12.4;\n" +
                        "Pt190GD = valor1_double/EUR;\n\n" +
                        "Teniendo en cuenta que su variable EUR ya se ha establecido y que valor1_double es " +
                        "el valor ingresado por el usuario.\n\n" +
                        "Ejemplo:\n" +
                        "Un típico ejemplo de su uso seria: “tal proyecto” costo 500,000.000 de " +
                        "euros o 0.001 RPI o esta misma cantidad en lingotes de platino 190.";

                Toast.makeText(this, "escrito id 1 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 2: encuacion en caso del uso de usar una bolsa con 12.4 kg (good delivery)
            // de diamantes de sangre
            case 2:

                escrito = "BBD por su abreviación en ingles Bag of Blood Diamon en una unidad de macro divisa " +
                        "basada en una bolsa de 12.4 kilogramos la cual contendría en su interior sin tener " +
                        "en cuenta el peso de la bolsa y se mide su cantidad basada en euros con la " +
                        "siguiente formula:\n\n" +
                        "double BBDGD;\n" +
                        "EUR = 4528394504.95  * 12.4;\n" +
                        "BBDGD = valor1_double/EUR;\n\n" +
                        "Teniendo en cuenta que su variable EUR ya se ha establecido y que valor1_double es " +
                        "el valor ingresado por el usuario.\n\n" +
                        "Ejemplo:\n" +
                        "Un típico ejemplo de su uso seria: “tal proyecto” costo 500,000.000 de " +
                        "euros o 0.008 BBD o bolsas de diamantes de sangre.";

                Toast.makeText(this, "escrito id 2 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 3: ecuacion en caso de usarse el pib promedio nominal mundial
            case 3:

                escrito = "AGW por su abreviación en ingles Average GDP World es una unidad de medida de macro " +
                        "divisa la cual explícitamente nos demuestra en el idioma inglés que es el numero " +
                        "equivalente al PIB nominal promedio mundial en euros el cual se mide por su " +
                        "conversión a euros con la siguiente formula:\n\n" +
                        "double PPNM;\n" +
                        "EUR = 82950900000000.0 / 190;\n" +
                        "PPNM = valor1_double/EUR;\n\n" +
                        "Teniendo en cuenta que su variable EUR ya se ha establecido y que valor1_double " +
                        "es el valor ingresado por el usuario.\n\n" +
                        "Ejemplo:\n" +
                        "Un típico ejemplo de su uso seria: “tal proyecto” costo 500,000.000 de " +
                        "euros o 0.001 AGW o PIB nominales mundiales promedio.\n";

                Toast.makeText(this, "escrito id 3 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 4: ecuacion en caso de usarse toneladas de oro como medicion
            case 4:

                escrito = "TAU por su abreviación en ingles ton Au (Au en referencia a la nomenclatura del oro) " +
                        "es una unidad de medida de macro divisa la cual se basa en el precio de una " +
                        "tonelada cubica de oro la cual se mide su conversión a euros de la siguiente manera:\n\n" +
                        "double TO;\n" +
                        "EUR = 1574.93 * 35274;\n" +
                        "TO = valor1_double/EUR;\n\n" +
                        "Teniendo en cuenta que su variable EUR ya se ha establecido y que valor1_double " +
                        "es el valor ingresado por el usuario.\n\n" +
                        "Ejemplo:\n" +
                        "Un típico ejemplo de su uso seria: “tal proyecto” costo 500,000.000 de " +
                        "euros o 9.00 TAU o toneladas de oro.";

                Toast.makeText(this, "escrito id 4 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 5: ecuacion en caso de usarse el bitcoin como unidad de medicion
            case 5:

                escrito = "BTC es la unidad ISO del bitcoin la cual se mide mediante la formula:\n\n" +
                        "double BTCv;\n" +
                        "BTCv = valor1_double/38406.9;\n\n" +
                        "Teniendo en cuenta que valor1_double es el valor ingresado por el usuario.\n" +
                        "Ejemplo:\n\n" +
                        "Un típico ejemplo de su uso seria: “tal proyecto” costo 500,000.000 de " +
                        "euros o 13,018.49 BTC o Bitcoins.";

                Toast.makeText(this, "escrito id 5 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 6: ecuacion en caso de usarse el derivado del dinar, volviendo este un centimo,
            // como unidad de medicion
            case 6:

                escrito = "PKD por su abreviación en ingles Penny kuwaití dinar es una unidad de medida de macro " +
                        "divisa la cual se basa en convertir el dinar kuwaití más fuerte con denominación " +
                        "de 20 en un céntimo y se mide su conversión a euros de la siguiente manera:\n" +
                        "\n" +
                        "double PKDv;\n" +
                        "PKDv = valor1_double/ 58.1878;\n" +
                        "PKDv = PKDv*0.01;\n" +
                        "Teniendo en cuenta que valor1_double es el valor ingresado por el usuario.\n" +
                        "\n" +
                        "Ejemplo:\n" +
                        "Un típico ejemplo de su uso seria: “tal proyecto” costo 500,000.000 millones de " +
                        "euros o 85,928.66 PKD o céntimo al dinar kuwaiti.";

                Toast.makeText(this, "escrito id 6 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 7: ecuacion en caso de usarse un kilo de francio como unidad de medida
            case 7:

                escrito = "KFR por su abreviación kilo Fr (francio en nomenclatura de la tabla periódica) es " +
                        "una unidad de medida de macro divisa la cual se basa en el precio de un kilo de " +
                        "francio la cual mide su conversión desde los euros de la siguiente manera:\n\n" +
                        "double KFRv;\n" +
                        "KFRv = valor1_double/ 4528394504950.05;\n\n" +
                        "Teniendo en cuenta que valor1_double es el valor ingresado por el usuario.\n\n" +
                        "Ejemplo:\n" +
                        "Un típico ejemplo de su uso seria: “tal proyecto” costo 500,000.000 de " +
                        "euros o 0.0001 KFR o kilos de francio.";

                Toast.makeText(this, "escrito id 7 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 8: ecuacion en caso de usarse un gramo de antimateria como unidad de medida
            case 8:

                escrito = "AMG por su abreviación en ingles AntiMatter Gram es una unidad de medida de macro " +
                        "divisa la cual se traduce como un gramo de antimateria el cual se mide su " +
                        "conversión a euros de la siguiente manera:\n\n" +
                        "double GAMv;\n" +
                        "EUR = 58869118313246480.0 / 1000;\n" +
                        "GAMv = valor1_double/ EUR;\n\n" +
                        "Teniendo en cuenta que su variable EUR ya se ha establecido y que valor1_double " +
                        "es el valor ingresado por el usuario.\n\n" +
                        "Ejemplo:\n" +
                        "Un típico ejemplo de su uso seria: “tal proyecto” costo 500,000.000 de " +
                        "euros o 0.000008 AMG o gramos de antimateria.";

                Toast.makeText(this, "escrito id 8 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 9
            // Default case
            default:

                // Print statement corresponding case
                Toast.makeText(this, "hubo un error inesperado en la seleccion switch texto",
                        Toast.LENGTH_LONG).show();
                escrito = "escrito indebido";
        }

        return escrito;
    }

    public double metodorazon (int entero) {

        switch (entero) {

            // Case 1: ecuacion en caso de que se use la divisa de lingotes good delivery de platino 190
            case 1:

                valor = 359373286221.92;
                Toast.makeText(this, "escrito valor 1 llega", Toast.LENGTH_SHORT).show();

                break;


            // Case 2: encuacion en caso del uso de usar una bolsa con 12.4 kg (good delivery)
            // de diamantes de sangre
            case 2:

                valor = 56152091861.38;

                Toast.makeText(this, "escrito valor 2 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 3: ecuacion en caso de usarse el pib promedio nominal mundial
            case 3:

                valor = 436583684210.5263157894736842;

                Toast.makeText(this, "escrito valor 3 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 4: ecuacion en caso de usarse toneladas de oro como medicion
            case 4:

                valor = 55554080.82;

                Toast.makeText(this, "escrito valor 4 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 5: ecuacion en caso de usarse el bitcoin como unidad de medicion
            case 5:

                valor = 42342;

                Toast.makeText(this, "escrito valor 5 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 6: ecuacion en caso de usarse el derivado del dinar, volviendo este un centimo,
            // como unidad de medicion
            case 6:

                valor = 58.1878;

                Toast.makeText(this, "escrito valor 6 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 7: ecuacion en caso de usarse un kilo de francio como unidad de medida
            case 7:

                valor = 4528394504950.05;

                Toast.makeText(this, "escrito valor 7 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 8: ecuacion en caso de usarse un gramo de antimateria como unidad de medida
            case 8:

                valor = 58869118313246.48;

                Toast.makeText(this, "escrito valor 8 llega", Toast.LENGTH_SHORT).show();

                break;

            // Case 9
            // Default case
            default:

                // Print statement corresponding case
                Toast.makeText(this, "hubo un error inesperado en la seleccion switch razon",
                        Toast.LENGTH_LONG).show();
                valor = 0;
        }

        return valor;

    }

}

