import java.util.Scanner;


public class Chess {
    static String init = "|   ";
    static String yellow = "| Y ";
    static String red = "| R ";
    static String[][] qi = new String[6][7];
    static int count = 0;  // 谁下子及下了多少子的判断计数器
    static Scanner input = new Scanner(System.in);
    static boolean condition = true;

    // 输赢标志位
    static boolean flagForYWin = false;
    static boolean flagForRWin = false;

    // 悬挂的四子棋
    public static void main(String[] args) {
        // 初始化棋子数组
        for (int i = 0; i < qi.length; ++i) {
            for(int j = 0; j < qi[0].length; ++j) {
                qi[i][j] = init;
            }
        }

        //画出原始棋盘
        showCheckerBoard(true);

        play();
    }

    public static void showCheckerBoard(boolean needClear) {
        if (needClear) {
            System.out.print("\033[H\033[2J");
        }
        System.out.println("-----------------------------");
        for (int i = qi.length - 1;i >= 0;i--){
            for (int j = 0; j < qi[0].length; ++j)
                System.out.print(qi[i][j]);
            System.out.println("|");
            System.out.println("-----------------------------");
        }
        for(int i = 0; i < qi[0].length; ++i) {
            System.out.print("* "+(i+1)+" ");
        }
        System.out.println("*");
    }

    public static void check(int row, int column) {
        // 输赢标志位
        flagForYWin = false;
        flagForRWin = false;

        // 只需对当前下子的周围情况进行判断来决定棋局结果
        if (count % 2 == 0) {  // yellow player is win?
            // 行检测开始
            if (column <= 3) {
                for (int jj = 0; jj <= column; ++jj)
                    if (qi[row][jj] == yellow
                            && qi[row][jj + 1] == yellow
                            && qi[row][jj + 2] == yellow
                            && qi[row][jj + 3] == yellow) {
                        flagForYWin = true;
                        condition = false;
                        return;
                    }
            } else {
                for (int jj = column - 3; jj <= 3; jj++)
                    if (qi[row][jj] == yellow
                            && qi[row][jj + 1] == yellow
                            && qi[row][jj + 2] == yellow
                            && qi[row][jj + 3] == yellow) {
                        flagForYWin = true;
                        condition = false;
                        return;
                    }
            }

            if (flagForYWin) {
                System.out.println("The Yellow player win the game!");
                condition = false;
                return;
            }

            // 列检测开始
            if (row >= 3) {
                if (qi[row][column] == yellow
                        && qi[row - 1][column] == yellow
                        && qi[row - 2][column] == yellow
                        && qi[row - 3][column] == yellow)
                    flagForYWin = true;
            }

            if (flagForYWin) {
                System.out.println("The Yellow player win the game!");
                condition = false;
                return;
            }

            // 正反对角检测
            if(row >= 3){
                if(column < 3) {
                    if (qi[row][column] == yellow
                            && qi[row - 1][column + 1] == yellow
                            && qi[row - 2][column + 2] == yellow
                            && qi[row - 3][column + 3] == yellow)
                        flagForYWin = true;
                }
                else if(column > 3) {
                    if (qi[row][column] == yellow
                            && qi[row - 1][column - 1] == yellow
                            && qi[row - 2][column - 2] == yellow
                            && qi[row - 3][column - 3] == yellow)
                        flagForYWin = true;
                }
                else {
                    if ((qi[row][column] == yellow
                            && qi[row - 1][column + 1] == yellow
                            && qi[row - 2][column + 2] == yellow
                            && qi[row - 3][column + 3] == yellow)
                            || (qi[row][column] == yellow
                            && qi[row - 1][column - 1] == yellow
                            && qi[row - 2][column - 2] == yellow
                            && qi[row - 3][column - 3] == yellow))
                        flagForYWin = true;
                }
            }

            if (flagForYWin) {
                System.out.println("The Yellow player win the game!");
                condition = false;
                return;
            }
        } else {  // red player is win?
            // 行检测开始
            if (column <= 3) {
                for (int jj = 0; jj <= column; ++jj)
                    if (qi[row][jj] == red
                            && qi[row][jj + 1] == red
                            && qi[row][jj + 2] == red
                            && qi[row][jj + 3] == red) {
                        flagForRWin = true;
                        condition = false;
                        return;
                    }
            } else {
                for (int jj = column - 3; jj <= 3; jj++)
                    if (qi[row][jj] == red
                            && qi[row][jj + 1] == red
                            && qi[row][jj + 2] == red
                            && qi[row][jj + 3] == red) {
                        flagForRWin = true;
                        condition = false;
                        return;
                    }
            }

            if (flagForRWin) {
                System.out.println("The Red player win the game!");
                condition = false;
                return;
            }

            // 列检测开始
            if (row >= 3) {
                if (qi[row][column] == red
                        && qi[row - 1][column] == red
                        && qi[row - 2][column] == red
                        && qi[row - 3][column] == red)
                    flagForRWin = true;
            }

            if (flagForRWin) {
                System.out.println("The Red player win the game!");
                condition = false;
                return;
            }

            // 正反对角检测
            if (row >= 3){
                if (column < 3){
                    if (qi[row][column] == red
                            && qi[row - 1][column + 1] == red
                            && qi[row - 2][column + 2] == red
                            && qi[row - 3][column + 3] == red)
                        flagForRWin = true;
                } else if(column > 3) {
                    if (qi[row][column] == red
                            && qi[row - 1][column - 1] == red
                            && qi[row - 2][column - 2] == red
                            && qi[row - 3][column - 3] == red) {
                        flagForRWin = true;
                    }
                } else {
                    if ((qi[row][column] == red
                            && qi[row - 1][column + 1] == red
                            && qi[row - 2][column + 2] == red
                            && qi[row - 3][column + 3] == red)
                            || (qi[row][column] == red
                            && qi[row - 1][column - 1] == red
                            && qi[row - 2][column - 2] == red
                            && qi[row - 3][column - 3] == red)) {
                        flagForRWin = true;
                    }
                }
            }

            if (flagForRWin) {
                System.out.println("The Red player win the game!");
                condition = false;
                return;
            }
        }

        ++count;  // 棋子数加1，并用于谁下棋子的判断

        // 棋盘下满棋子，平局
        if(count == 6 * 7){
            System.out.println("棋盘棋子已经下满，平局！");
            condition = false;
            return;
        }
    }

    public static void play() {
        int row = 0, column = 0;  // 行列下标初始化
        // 下棋循环开始
        while (true) {
            row = 0;
            column = 0;
            if (count % 2 == 0) {  // 黄方下子
                System.out.print("\n\nY player please drop a Yellow disk at column(1~7): ");
                while (true) {  // 黄方下子循环开始
                    column = input.nextInt() - 1;
                    if (column >= 0 && column <= 6) {// 输入合法进行下子
                        for (row = 0; row < qi.length; row++) {
                            if (qi[row][column] == init) {
                                qi[row][column] = yellow;
                                break;
                            }
                        }

                        if (row == qi.length) {  // 该列棋子满，重新输入
                            System.out.print("The column of you enter is full, please reEnter! : ");
                        } else {  // 棋子没满，下子结束
                            break;
                        }
                    } else {  // 输入不合法，重新下子
                        System.out.print("You enter the wrong column,s please reEnter!: ");
                    }
                }  // 黄方下子循环结束
            } else {  // 红方下子
                System.out.print("\n\nR player please drop a Yellow disk at column(1~7): ");
                while (true) {  // 红方下子循环开始
                    column = input.nextInt() - 1;
                    if (column >= 0 && column <= 6) {// 输入合法进行下子
                        for (row = 0; row < qi.length; row++) {
                            if (qi[row][column] == init) {
                                qi[row][column] = red;
                                break;
                            }
                        }
                        if (row == qi.length)  { //该列棋子满，重新输入
                            System.out.print("The column of you enter is full, please reEnter! : ");
                        }
                        else  { //棋子没满，下子结束
                            break;
                        }
                    } else  {// 输入不合法，重新下子
                        System.out.print("You enter the wrong column, please reEnter!: ");
                    }
                }
            }

            check(row, column);
            if (!condition) {
                showCheckerBoard(false);
                break;
            }

            // 画出棋盘
            showCheckerBoard(true);
        }  // 下棋循环结束

    }
}
