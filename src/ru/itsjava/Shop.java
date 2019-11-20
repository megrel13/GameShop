package ru.itsjava;

import java.util.*;

public class Shop {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        String enterNumOfMenu = "Введите номер меню от 0 до 7.";
        Scanner scanner = new Scanner(System.in);
        int numOfMenu;

        Game[] games = new Game[]{new Game("Contra"), new Game("Warcraft3"), new Game("Half-Life2"), new Game("Mario"), new Game("FlatOut2"),
                new Game("Mortal-Kombat"), new Game("BomberMan"), new Game("BookOfJungle"), new Game("Sonic"), new Game("NeedForSpeed")};

        Game recentGame = null;
        printMenu(enterNumOfMenu);
        while ((numOfMenu = scanner.nextInt()) != 0) {
            if ((numOfMenu < 0) || (numOfMenu > 8)) {
                System.out.println("Вы ввели некорректный номер меню (" + numOfMenu + ")."
                        + enterNumOfMenu);
                System.exit(-1);
            }
            switch (numOfMenu) {
                case 1:
                    showAllGames(games);
                    break;
                case 2:
                    games = addGame(scanner, games);
                    recentGame = games[games.length - 1];
                    break;
                case 3:
                    rentGame(scanner, games);
                    break;
                case 4:
                    games = buyGame(scanner, games);
                    break;
                case 5:
                    if (recentGame != null) {
                        showLastAddGame(recentGame);
                    } else {
                        System.out.println("Ни одной игры еще не было добавлено!");
                    }
                    break;
                case 6:
                    sortGames(games);
                    break;
                case 7:
                    returnRent(scanner, games);
                    break;
            }
            printMenu(enterNumOfMenu);
            System.out.println("Введите номер меню");
        }
        System.out.println("Спасибо, что воспользовались нашим магазином. Приходите еще!");
        scanner.close();
    }

    private static void returnRent(Scanner scanner, Game[] games) {
        System.out.println("Введите имя игры, которую хотите вернуть");
        var gameNameToReturn = scanner.next();

        for (var game : games) {
            if (game.getName().contains(gameNameToReturn) && game.isRented()) {
                game.setRented(false);
            }
        }
    }

    private static void showLastAddGame(Game game) {
        System.out.println("Последняя добавленная игра: " + game.getName());

    }

    private static void sortGames(Game[] games) {
        System.out.println("Cортировка игр по алфавиту прошла успешно!");
        ArrayList<String> =
    }

    private static void rentGame(Scanner scanner, Game[] games) {
        System.out.println("Введите игру, которую хотите арендовать: ");
        String sRentGame = scanner.next();

        for (var game : games) {
            if (game.getName().equals(sRentGame)) {
                if (game.isRented()) {
                    System.out.println("Игра " + sRentGame + " уже арендована");
                    return;
                }

                System.out.println("Игра " + sRentGame + " была арендована.");
                game.setRented(true);
                return;
            }
        }
    }

    private static Game[] buyGame(Scanner scanner, Game[] games) {
        System.out.println("Введите игру которую хотите купить: ");
        String sBuyGame = scanner.next();

        var resArray = new Game[games.length - 1];
        int indexResArray = 0;

        for (int i = 0; i < games.length; i++) {
            if (games[i].getName().equals(sBuyGame)) {
                System.out.println("Игра " + sBuyGame + " успешно куплена!");
                continue;
            }

            if (indexResArray == resArray.length) {
                System.out.println("Такой игры не существует!");
                return games;
            }

            resArray[indexResArray++] = games[i];
        }
        return resArray;
    }

    private static Game[] addGame(Scanner scanner, Game[] games) {
        var resGames = Arrays.copyOf(games, games.length + 1);

        System.out.println("Введи новое имя игры:");
        var inputGameName = scanner.next();
        var newGame = new Game(inputGameName);

        resGames[resGames.length - 1] = newGame;

        System.out.println("Игра '" + newGame.getName() + "' успешно добавлена!!");

        return resGames;
    }

    private static void showAllGames(Game[] games) {
        System.out.println("Вывод всех игр:");

        for (var game : games) {
            var rentedMessage = "";

            if (game.isRented()) {
                rentedMessage = " арендована";
            }

            System.out.println(game.getName() + rentedMessage);
        }
    }

    public static void printMenu(String enterNumOfMenu) {
        //charAt()
        System.out.println("Меню:\n" +
                "1. Показать все игры.\n" +
                "2. Добавить игру в список.\n" +
                "3. Сдать игру в аренду.\n" +
                "4. Купить игру.\n" +
                "5. Вывести недавно добавленную игру.\n" +
                "6. Отсортировать игры.\n" +
                "7. Вернуть игру из аренды.\n" +
                "0. Выход.\n" + enterNumOfMenu);
    }
}