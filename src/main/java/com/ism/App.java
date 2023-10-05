package com.ism;
import com.ism.entities.ArticleConfection;
import com.ism.entities.Categorie;
import com.ism.entities.Unite;
import com.ism.repositories.ITables;
import com.ism.repositories.list.TableArticleConfections;
import com.ism.repositories.list.TableCategories;
import com.ism.repositories.list.TableUnites;
import com.ism.services.ArticleConfectionServiceImpl;
import com.ism.services.CategorieServiceImpl;
import com.ism.services.UniteServiceImpl;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Table Categorie
        ITables<Categorie> repository = new TableCategories();
        CategorieServiceImpl categorieServiceImpl = new CategorieServiceImpl(repository);

        //Table Unite
        ITables<Unite> repositoryUnite = new TableUnites();
        UniteServiceImpl uniteServiceImpl = new UniteServiceImpl(repositoryUnite);

        //Table ArticleConfection
        ITables<ArticleConfection> repositoryArticleConfection = new TableArticleConfections();
        ArticleConfectionServiceImpl articleConfectionServiceImpl = new ArticleConfectionServiceImpl(repositoryArticleConfection);

        //Variables des switch case (MENU)
        int choix;
        int choixAjout;
        int choixAffichage;
        //Variables Suppression
        int choixSupCat;
        int choixSupCatArtConf;
        int idCatSup;
        int idArtSup;
        //Variables modification
        int modCatArt;
        int idCatMod;
        int idArtMod;
        //int idNewCat;


        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n######### MENU #########");
            System.out.println("1-Ajouter");
            System.out.println("2-Lister");
            System.out.println("3-Supprimer");
            System.out.println("4-Modifier");
            System.out.println("5-Quitter");
            System.out.print("########################\nEntrez votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1: //Ajout
                    do {
                        System.out.println("\n#######################");
                        System.out.println("1-Ajouter une catégorie");
                        System.out.println("2-Ajouter une unité");
                        System.out.println("3-Ajouter un article de confection");
                        System.out.println("4-Quitter");
                        System.out.println("#######################");
                        System.out.println("Entrez votre choix : ");
                        choixAjout = scanner.nextInt();
                        scanner.nextLine();
                        switch (choixAjout) {
                            case 1://Ajouter Categorie
                                char reponseCat = 'y';
                                while (reponseCat == 'y') {
                                    System.out.println("Entrez le libelle de la categorie : ");
                                    Categorie categorie = new Categorie(scanner.nextLine());
                                    categorieServiceImpl.add(categorie);
                                    System.out.println("Voulez-vous continuer à ajouter ? (y/n) ");
                                    reponseCat = scanner.nextLine().charAt(0);
                                }
                                break;
                            case 2://Ajouter Unite
                                char reponseUni = 'y';
                                while (reponseUni == 'y') {
                                    System.out.println("Entrez le libelle de l'unité : ");
                                    Unite unite = new Unite(scanner.nextLine());
                                    uniteServiceImpl.add(unite);
                                    System.out.println("Voulez-vous continuer à ajouter ? (y/n) ");
                                    reponseUni = scanner.nextLine().charAt(0);
                                }
                                break;
                            case 3://Ajouter Article Confection
                                System.out.println("Entrez le libelle de l'article de confection : ");
                                ArticleConfection articleConfection = new ArticleConfection(scanner.nextLine());
                                articleConfectionServiceImpl.add(articleConfection);
                                System.out.println("Entrez le prix l'article de confection : ");
                                double prix = scanner.nextInt();
                                articleConfection.setPrix(prix);
                                System.out.println("Entrez la quantite de l'article de confection : ");
                                int qte = scanner.nextInt();
                                articleConfection.setQte(qte);
                                //Ajout Categorie Article
                                System.out.println("\n#### LISTE DE CATEGORIES A CHOISR ####");
                                categorieServiceImpl.getAll().forEach(System.out::println);
                                System.out.println("Choisir la categorie (via ID) :");
                                int idCat = scanner.nextInt();
                                if (categorieServiceImpl.show(idCat) != null) {
                                    articleConfection.setCategorie(categorieServiceImpl.show(idCat));
                                    System.out.println("\n####### ARTICLES DE CONFECTION : ###########");
                                    articleConfectionServiceImpl.getAll().forEach(System.out::println);
                                } else {
                                    System.out.println("Index Introuvable !!");
                                }
                                break;
                            default:
                                break;
                        }
                    } while (choixAjout != 4);
                    break;

                case 2://Affichage
                    do {
                        System.out.println("\n########################");
                        System.out.println("1-Lister les catégories");
                        System.out.println("2-Lister les unités");
                        System.out.println("3-Lister articles de confection");
                        System.out.println("4-Quitter");
                        System.out.println("########################");
                        System.out.println("Entrez votre choix : ");
                        choixAffichage = scanner.nextInt();
                        switch (choixAffichage) {
                            case 1:
                                System.out.println("\n###LISTE CATEGORIES :###");
                                categorieServiceImpl.getAll().forEach(System.out::println);
                                break;
                            case 2:
                                System.out.println("\n### LISTE UNITES :###");
                                uniteServiceImpl.getAll().forEach(System.out::println);
                                break;
                            case 3:
                                System.out.println("\n####### LISTE ARTICLES DE CONFECTION : ###########");
                                articleConfectionServiceImpl.getAll().forEach(System.out::println);
                                break;
                            default:
                                break;
                        }
                    } while (choixAffichage != 4);
                    break;

                case 3://Suppression du libelle categorie et Article confection
                    do {
                        System.out.println("\n########################");
                        System.out.println("1-Supprimer une categorie");
                        System.out.println("2-Supprimer un article de confection");
                        System.out.println("3-Quitter");
                        System.out.println("########################\nEntrez votre choix : ");
                        choixSupCatArtConf = scanner.nextInt();
                        scanner.nextLine();
                        switch (choixSupCatArtConf) {
                            case 1://Suppression du libelle categorie
                                do {
                                    System.out.println("\n########################");
                                    System.out.println("1-Suppression simple");
                                    System.out.println("2-Suppression Multiple");
                                    System.out.println("3-Quitter");
                                    System.out.println("########################\nEntrez votre choix : ");
                                    choixSupCat = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (choixSupCat) {
                                        case 1://Suppression simple categorie
                                            do {
                                                System.out.println("Entrez l'ID de la categorie à supprimer : ");
                                                idCatSup = scanner.nextInt();
                                                if (categorieServiceImpl.show(idCatSup) != null) {
                                                    System.out.println("L'élément à supprimer est : " + categorieServiceImpl.show(idCatSup) /*repository.findByID(idCatSup)*/);
                                                    //categorieServiceImpl.remove(idCatSup);
                                                    repository.delete(idCatSup);
                                                    System.out.println("Suppression effectuée avec succès !!!");
                                                    System.out.println("\n######## CATEGORIES APRES SUPPRESSION : ########\n");
                                                    categorieServiceImpl.getAll().forEach(System.out::println);
                                                    break;
                                                } else {
                                                    System.out.println("ID introuvable !!!\n");
                                                }
                                            } while (idCatSup != repository.indexOf(idCatSup));
                                            break;
                                        case 2://Suppression Multiple categorie
                                            System.out.println("Entrez le nombre de libelle à supprimer : ");
                                            int N = scanner.nextInt();
                                            int[] tabsup = new int[N];
                                            System.out.println("Entrez les ID des categories à supprimer :");
                                            for (int i = 0; i < N; i++) {
                                                System.out.println("ID " + (i + 1) + " : ");
                                                tabsup[i] = scanner.nextInt();
                                            }
                                            System.out.println("\nIndices des libelles à supprimer: \n" + Arrays.toString(tabsup));
                                            for (int i = 0; i < N; i++) {
                                                if (categorieServiceImpl.show(tabsup[i]) != null) {
                                                    repository.delete(tabsup[i]);
                                                } else {
                                                    System.out.println("ID " + tabsup[i] + " introuvable !!!\n");
                                                }
                                            }
                                            System.out.println("Suppression effectuée avec succès !!!");
                                            System.out.println("\n#### CATEGORIES APRES SUPRESSION MULTIPLE : ####");
                                            categorieServiceImpl.getAll().forEach(System.out::println);
                                            break;
                                        default:
                                            break;

                                    }
                                } while (choixSupCat != 3);
                                break;
                            case 2://Suppression Article Confection
                                do {
                                    System.out.println("Entrez l'ID de l'article de confection à supprimer : ");
                                    idArtSup = scanner.nextInt();
                                    if (articleConfectionServiceImpl.show(idArtSup) != null) {
                                        System.out.println("L'élément à supprimer est : " + articleConfectionServiceImpl.show(idArtSup));
                                        articleConfectionServiceImpl.remove(idArtSup);
                                        System.out.println("Suppression effectuée avec succès !!!");
                                        System.out.println("\n######## ARTICLES APRES SUPPRESSION : ########\n");
                                        articleConfectionServiceImpl.getAll().forEach(System.out::println);
                                        break;
                                    } else {
                                        System.out.println("ID introuvable !!!\n");
                                    }
                                } while (idArtSup != repository.indexOf(idArtSup));
                                break;
                            default:
                                break;
                        }
                    } while (choixSupCatArtConf != 3);
                    break;

                case 4: //Modification du libelle
                    do {
                        System.out.println("\n########################");
                        System.out.println("1-Modifier categorie");
                        System.out.println("2-Modifier article confection");
                        System.out.println("3-Quitter");
                        System.out.println("########################\nEntrez votre choix : ");
                        modCatArt = scanner.nextInt();
                        scanner.nextLine();
                        switch (modCatArt) {
                            case 1://Modification categorie
                                do {
                                    System.out.println("Entrez l'ID de la categorie à modifier : ");
                                    idCatMod = scanner.nextInt();
                                    scanner.nextLine();
                                    if (categorieServiceImpl.show(idCatMod) != null) {
                                        System.out.println("L'élément à modifier est : " + categorieServiceImpl.show(idCatMod));
                                        System.out.println("Entrez le nouveau libelle : ");
                                        Categorie categorieMod = new Categorie(idCatMod, scanner.nextLine());
                                        categorieServiceImpl.update(categorieMod);
                                        System.out.println("Modification effectuée avec succès !!!\n");
                                        System.out.println("######## CATEGORIES APRES MODIFICATION: ########");
                                        categorieServiceImpl.getAll().forEach(System.out::println);
                                        break;
                                    } else {
                                        System.out.println("ID Introuvable !!!");
                                    }
                                } while (idCatMod != repository.indexOf(idCatMod));
                                break;
                            case 2://Modification Article Confection
                                articleConfectionServiceImpl.getAll().forEach(System.out::println);
                                do {
                                    System.out.println("Entrez l'ID de l'article à modifier : ");
                                    idArtMod = scanner.nextInt();
                                    scanner.nextLine();
                                    if (articleConfectionServiceImpl.show(idArtMod) != null) {
                                        System.out.println("L'article à modifier est : " + articleConfectionServiceImpl.show(idArtMod));
                                        System.out.println("Entrez le nouveau prix de l'article de confection : ");
                                        double prix = scanner.nextInt();
                                        System.out.println("Entrez la nouvelle quantite de l'article de confection : ");
                                        int qte = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Entrez le nouveau libelle de l'article de confection : ");
                                        ArticleConfection articleMod = new ArticleConfection(idArtMod, scanner.nextLine(),prix,qte);
                                        repositoryArticleConfection.update(articleMod);
                                        System.out.println("\n#### LISTE DE CATEGORIES A CHOISR ####");
                                        categorieServiceImpl.getAll().forEach(System.out::println);
                                        System.out.println("Choisir la categorie (via ID) :");
                                        int idCat = scanner.nextInt();
                                        if (categorieServiceImpl.show(idCat) != null) {
                                            System.out.println("\nModification effectuée avec succès !!!");
                                            articleMod.setCategorie(categorieServiceImpl.show(idCat));
                                            System.out.println("\n####### ARTICLES DE CONFECTION APRES MODIFICATION: ###########");
                                            articleConfectionServiceImpl.getAll().forEach(System.out::println);

                                            break;
                                        } else {
                                            System.out.println("Index Introuvable !!");
                                        }
                                        break;
                                    }else {
                                        System.out.println("ID Introuvable !!!");
                                    }
                                }while (idArtMod != repository.indexOf(idArtMod));
                                break;
                        }

                    }while (modCatArt != 3);
                    break;
            }
        }while (choix != 5);
    }
}
