package views.dashboard;

import java.util.HashMap;
import java.util.function.Function;


import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import models.dashboard.DashboardModel;
import views.utils.ResourceLoader;
import views.utils.Responsive;

/**
 * Clase que representa la vista del dashboard.
 */
public class DashboardView implements Builder<Region> {
    private final Region buyView;
    private final Region loanView;
    private final Region saleView;
    private final Region topBarView;
    private final Region sideBarView;
    private final HashMap<String, Function<?, ?>> service;
    private final DashboardModel model;
    private StackPane contentContainer;

    /**
     * Constructor de la vista del dashboard.
     *
     * @param buyView  Vista de la sección de compras.
     * @param loanView Vista de la sección de préstamos.
     * @param saleView Vista de la sección de ventas.
     * @param service  Mapa de servicios disponibles.
     * @param model    Modelo del dashboard.
     */
    public DashboardView(Region sideBarView,Region topBarView,Region buyView, Region loanView, Region saleView,
                         HashMap<String, Function<?, ?>> service, DashboardModel model) {
        this.buyView = buyView;
        this.loanView = loanView;
        this.saleView = saleView;
        this.topBarView = topBarView;  
        this.sideBarView = sideBarView;
        this.service = service;
        this.model = model;

        buyView.visibleProperty().bind(model.buyViewVisibleProperty());
        loanView.visibleProperty().bind(model.loanViewVisibleProperty());
        saleView.visibleProperty().bind(model.saleViewVisibleProperty());

    }

    @Override
    public Region build() {
        return (Region) mainContainer();
    }

    /**
     * Crea el contenedor principal del dashboard.
     *
     * @return Nodo que representa el contenedor principal.
     */
    private Node mainContainer() {
        HBox container = new HBox(
                sideBarView,
                createContentContainer()
        );
        container.getStylesheets().add(ResourceLoader.load("/css/dashboard/dashboard.css"));
        container.getStyleClass().add("container");
        container.setPadding(new Insets(10, 10, 10, 10));
        return container;
    }

   

    /**
     * Crea el contenedor de contenido principal.
     *
     * @return Nodo que representa el contenedor de contenido.
     */
    private Node createContentContainer() {
        VBox innerContentContainer = new VBox(
                topBarView,
                createContent()
        );
        Responsive.bindingToParentWidth(innerContentContainer, 1);
        HBox contentContainer = new HBox(innerContentContainer);
        contentContainer.setHgrow(contentContainer, Priority.ALWAYS);
        contentContainer.getStyleClass().add("content");
        contentContainer.setPadding(new Insets(0, 0, 0, 15));
        return contentContainer;
    }

    /**
     * Crea el área de contenido donde se mostrarán las vistas.
     *
     * @return Nodo que representa el área de contenido.
     */
    private Node createContent() {
        contentContainer = new StackPane(buyView, loanView, saleView);
        Responsive.bindingToParent(contentContainer, 1, 1);

        // Listener para cambios en la vista activa
       

        return contentContainer;
    }

    

 
}