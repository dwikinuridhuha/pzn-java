// membuat class AplikasiTodoList
class TodoList {
    public String[] data = new String[10];

    public void tambah(String todo) {
        // cek apakah data penuh
        boolean isFull = true;
        for (String datum : data) {
            if (datum == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            String[] temp = data;
            data = new String[data.length * 2];

            System.arraycopy(temp, 0, data, 0, temp.length);
        }

        // tambahkan ke posisi yang data arraynya null
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todo;
                break;
            }
        }
    }

    public void hapus(int nomor) {
        if ((nomor - 1) >= data.length) {
            System.out.println("Todo dengan nomor " + nomor + " tidak ada");
        } else if (data[nomor - 1] == null) {
            System.out.println("Todo dengan nomor " + nomor + " tidak ada");
        } else {
            for (int i = (nomor - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
        }
    }

    public void tampilkan() {
        System.out.println("TODOLIST");
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                System.out.println((i + 1) + ". " + data[i]);
            }
        }
    }
}

public class AplikasiTodoList {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.tambah("Belajar Java Dasar");
        todoList.tambah("Membuat Aplikasi Todo List");
        todoList.tambah("Membuat Aplikasi Todo List 2");
        todoList.tampilkan();

        todoList.hapus(2);
        todoList.tampilkan();

        todoList.hapus(5);
    }
}
