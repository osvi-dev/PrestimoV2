package interactors.buy.buyInteractors;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import models.buy.buyModels.BuyJewelryModel;

public class BuyJewelryInteractor {
    private final BuyJewelryModel model;

    public BuyJewelryInteractor(BuyJewelryModel model){
        this.model = model;
        createBindings();
    }

    private void createBindings(){
        model.selectors_purchase_node().bind(Bindings.createBooleanBinding(
            () -> !(model.caratage_node().get() && model.weight_node().get()), // Condición: ambos deben ser verdaderos
            model.caratage_node(), model.weight_node() // Observa cambios en estas propiedades
        ));
    }
     public Void calculateJewelry(){
        /*
         * Pienso que sera mejor guardar los datos de la tabla variables en la base de datos
         */
        
        /*
         * TODO: Debemos extraer los datos de seguridad de la base de datos de la tabla variables
         * para poder hacer los calculos, esto se hara una vez dado los valores
         * los traeremos, creo que una opcion sera una vez iniciada la app, aplicar persistencia
         * para los valores y no hacer una consulta diaria.
         */
        Platform.runLater(()->{
            model.price_gr_inter().set(
                model.price_onz().divide(model.conversion_factor().get()).get()
            ); // precio x gramos
            model.revenue_extern_sale().set(
                model.price_gr_inter().subtract(model.security_value().get()).get()
            ); // ganancia de venta externa
           model.price_local_gr().set(
            model.revenue_extern_sale().subtract(model.revenue_gr().get()).get()
           ); //precio gramo local
    
           model.caratage_price().set(
            model.price_local_gr().divide(24).get()
           ); // precio kilataje
            double caratagePriceFinal = model.caratage_price().get() * model.caratage().get() * model.percentages_caratage().applied().get();
          
            // Vincula el resultado al precio final
            model.caratage_price_final().set(caratagePriceFinal);// Precio a pagar por kilataje (min,inter,max)
    
    
        model.price_gr_final().set(
            model.weight().multiply(
                model.caratage_price_final().get()
            ).get()
    
        ); // Precio a pagar por gramo Final
    
        model.max_purchase_amount().set(
            model.price_gr_final().multiply(
                model.percentages_buy().applied().get()
            ).get()
        ); // Monto maximo a pagar por compra
    
        });

        return null;
    }

    public Void printAllModel(){
        System.out.println(
            "Metal: "+ model.metal().get()+"\n"+
            "Kilataje: "+ model.caratage().get()+"\n"+
            "Peso: "+ model.weight().get()+"\n"+
            "Precio_Onza: "+ model.price_onz().get()+"\n"+
            "Factor de conversion: "+ model.conversion_factor().get()+"\n"+
            "Precio_gr_internacional: "+ model.price_gr_inter().get()+"\n"+
            "Valor de seguridad: "+ model.security_value().get()+"\n"+
            "Ganancia venta externa: "+ model.revenue_extern_sale().get()+"\n"+
            "Ganancia x gramo: "+ model.revenue_gr().get()+"\n"+
            "Precio_local_gr: "+ model.price_local_gr().get()+"\n"+
            "Kilataje precio: "+ model.caratage_price().get()+"\n"+
            "Kilataje_precio_final: "+ model.caratage_price_final().get()+"\n"+
            "Precio_gr_final: "+ model.price_gr_final().get()+"\n"+
            "Maximo monto de compra: "+ model.max_purchase_amount().get()+"\n"+
            "Porcentaje compra : "+ model.percentages_buy().applied().get()+"\n"+
            "Porcentaje kilataje: "+ model.percentages_caratage().applied().get()+"\n");
            return null;
    }

    
}
