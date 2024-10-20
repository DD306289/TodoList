public class AplikasiTodoList {

    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    //3 method dibawah untuk bisnis logicnya
    //Menampilkan todo list
    public static void showTodoList() {

        System.out.println("TODOLIST");

        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var numb = i + 1;

            if (todo != null) {
                System.out.println(numb + ". " + todo);
            }
        }
    }

    /*public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Belajar PHP";
        model[2] = "Belajar JavaScript";
        showTodoList();
    }*/

    //Menambah todo ke List
    public static void addTodoList(String todo) {

        //Cek apakah model penuh?
        var isFull = true;
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        //Jika penuh, resize ukuran array 2x lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        //Tambahkan ke posisi yang data arraynya null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    /*public  static void testAddTodoList() {
        for (var i = 1; i < 25; i++) {
            addTodoList("Contoh todo ke. " + i);
        }

        showTodoList();

    }*/

    //menghapus todo dari list
    public static boolean removeTodoList(Integer numb) {
        //pengecekan untuk menghapus todo list
        /*kenapa (numb - 1) karena pada method showTodoList terdapat code var numb = i + 1;
          yang artinya array dimulai dari 1 bukan 0.
         */
        if ((numb - 1) >= model.length) {
            return false;
        } else if (model[numb - 1] == null) {
            return false;
        } else {
            for (var i = (numb - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
        //return false artinya array akan menjadi kosong kembali

    }

    /*public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }*/

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    /*public static void testInput() {
        var name = input("nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }*/

    //3 method dibawah berguna untuk menampilkan todo list
    //menampilkan view todo list
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();

            System.out.println("Menu :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak ada");
            }
        }
    }

    /*public static void testViewShowTodoList() {
        for (var i = 1; i < 10; i++) {
            addTodoList("Contoh todo ke. " + i);
        }

        viewShowTodoList();
    }*/

    //menampilkan view add todo list
    public static void viewAddTodoList() {
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x Jika Batal)");

        if (todo.equals("x")) {
            //batal
        } else {
            addTodoList(todo);
        }
    }

    /*public static void testViewAddTodoList() {
        viewAddTodoList();

        showTodoList();
    }*/

    //menampilkan view remove todo list
    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODOLIST");

        var numb = input("Nomor yang dihapus (x Jika Batal)");

        if (numb.equals("x")) {
            //batal
        } else {
            boolean succeed = removeTodoList(Integer.valueOf(numb));
            if (!succeed) {
                System.out.println("Gagal menghapus todolist : " + numb);
            }
        }
    }

    /*public static void testViewRemoveTodoList() {
        for (var i = 1; i < 5; i++) {
            addTodoList("Urutan ke- " + i);
        }

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }*/
}
