package com.example.conversor_macro_divisas_beta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    //private EditText et1;
    String DC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //et1 = (EditText)findViewById(R.id.et1);

    }

    public void loadRPI (View View) {

        DC = "RPI por su abreviación en ingles Rare Platinum Ingot es una unidad de macro divisa " +
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

        enviar(DC);

    }

    public void loadBBD (View View) {

        DC = "BBD por su abreviación en ingles Bag of Blood Diamon en una unidad de macro divisa " +
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

        enviar(DC);

    }

    public void loadAGW (View View) {

        DC = "AGW por su abreviación en ingles Average GDP World es una unidad de medida de macro " +
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

        enviar(DC);

    }

    public void loadTAU (View View) {

        DC = "TAU por su abreviación en ingles ton Au (Au en referencia a la nomenclatura del oro) " +
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

        enviar(DC);

    }

    public void loadBTC (View View) {

        DC = "BTC es la unidad ISO del bitcoin la cual se mide mediante la formula:\n\n" +
                "double BTCv;\n" +
                "BTCv = valor1_double/38406.9;\n\n" +
                "Teniendo en cuenta que valor1_double es el valor ingresado por el usuario.\n" +
                "Ejemplo:\n\n" +
                "Un típico ejemplo de su uso seria: “tal proyecto” costo 500,000.000 de " +
                "euros o 13,018.49 BTC o Bitcoins.";

        enviar(DC);

    }

    public void loadPKD (View View) {

        DC = "PKD por su abreviación en ingles Penny kuwaití dinar es una unidad de medida de macro " +
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

        enviar(DC);

    }

    public void loadKFR (View View) {

        DC = "KFR por su abreviación kilo Fr (francio en nomenclatura de la tabla periódica) es " +
                "una unidad de medida de macro divisa la cual se basa en el precio de un kilo de " +
                "francio la cual mide su conversión desde los euros de la siguiente manera:\n\n" +
                "double KFRv;\n" +
                "KFRv = valor1_double/ 4528394504950.05;\n\n" +
                "Teniendo en cuenta que valor1_double es el valor ingresado por el usuario.\n\n" +
                "Ejemplo:\n" +
                "Un típico ejemplo de su uso seria: “tal proyecto” costo 500,000.000 de " +
                "euros o 0.0001 KFR o kilos de francio.";

        enviar(DC);

    }

    public void loadAMG (View View) {

        DC = "AMG por su abreviación en ingles AntiMatter Gram es una unidad de medida de macro " +
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

        enviar(DC);

    }

    public void volverinicio (View view) {

        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);

    }

    public void enviar (String dc) {

        Intent documento = new Intent(this, MainActivity3.class);
        //documento.putExtra("escrito", et1.getText().toString());
        documento.putExtra("escrito", dc);
        startActivity(documento);

    }
}