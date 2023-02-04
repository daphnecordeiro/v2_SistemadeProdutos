package Menus;

import Enums.EnumCategoria;
import Interfaces.MenuClienteAcoes;
import Produtos.ProdutoAbstrato;

import java.util.*;

public abstract class MenuClienteAbstract implements MenuClienteAcoes  {

    protected static Scanner sc;

    protected List<ProdutoAbstrato> listaProdutos = new ArrayList<>();

    public MenuClienteAbstract(Scanner sc, List<ProdutoAbstrato> listaProdutos) {
        this.listaProdutos=listaProdutos;
        this.sc = sc;
    }

    @Override
    public void visualizarProdutos() {
        for (ProdutoAbstrato produto : listaProdutos) {
            System.out.println(produto);
        }
    }
    @Override
    public void filtrarPorCategoria() {
        System.out.println("Filtrar pela categoria: (m)Mercado/(l)Livro/(i)Informática");
        char opcaoFiltroPorCategoria = sc.next().charAt(0);
        if (opcaoFiltroPorCategoria == 'm') {
            for (ProdutoAbstrato produto : listaProdutos) {
                if (produto.getCategoria().equals(EnumCategoria.MERCADO)) {
                    System.out.println(produto);
                }
            }
        }
        if (opcaoFiltroPorCategoria == 'l') {
            for (ProdutoAbstrato produto : listaProdutos) {
                if (produto.getCategoria().equals(EnumCategoria.LIVRO)) {
                    System.out.println(produto);
                }
            }
        }
        if (opcaoFiltroPorCategoria == 'i') {
            for (ProdutoAbstrato produto : listaProdutos) {
                if (produto.getCategoria().equals(EnumCategoria.INFORMATICA)) {
                    System.out.println(produto);
                }
            }
        }
    }

    @Override
    public void filtrarPorMarca() {
        System.out.println("Digite a marca:");
        String opcaoFiltrarPorMarca = sc.next();
        for (ProdutoAbstrato produto : listaProdutos) {
            if (produto.getMarca().equals(opcaoFiltrarPorMarca)) {
                System.out.println(produto);
            }
        }
    }

    @Override
    public void ordenarPorNome() {
        System.out.println("Ordenar a lista por nome na ordem crescente ou descrescente?(c/d)");
        char opcaoOrdemNome = sc.next().charAt(0);
        if (opcaoOrdemNome == 'c') {
            Collections.sort(listaProdutos);
            for (ProdutoAbstrato produto : listaProdutos) {
                System.out.println(produto);
            }
        }
        if (opcaoOrdemNome == 'd') {
            Collections.reverse(listaProdutos);
            for (ProdutoAbstrato produto : listaProdutos) {
                System.out.println(produto);
            }
        }
    }

    @Override
    public void ordenarPorPreco() {
        System.out.println("Ordenar a lista por preço na ordem crescente ou descrescente?(c/d)");
        char opcaoOrdemPreco = sc.next().charAt(0);
        if (opcaoOrdemPreco == 'c') {
            Collections.sort(listaProdutos, Comparator.comparing(ProdutoAbstrato::getPreco));
            for (ProdutoAbstrato produto : listaProdutos) {
                System.out.println(produto);
            }
        }
        if (opcaoOrdemPreco == 'd') {
            Collections.reverse(listaProdutos);
            for (ProdutoAbstrato produto : listaProdutos) {
                System.out.println(produto);
            }
        }

    }

    public List<ProdutoAbstrato> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<ProdutoAbstrato> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
