package Hw2_22001235_NguyenNgocAnh.Exercise2;

public class Test {
    public static void main(String[] args) {
        SimpleArrayList<String> list = new SimpleArrayList<>();

        if (!list.isEmpty()) {
            System.out.println("Danh sách ban đầu không rỗng");
        } else {
            System.out.println("Danh sách ban đầu rỗng");
        }

        list.add("Hello");
        list.add("World");
        list.add("Java");

        if (list.size() != 3) {
            System.out.println("Số lượng phần tử không đúng");
        } else {
            System.out.println("Số lượng phần tử đúng");
        }

        if (!list.get(0).equals("Hello") || !list.get(1).equals("World")) {
            System.out.println("Lấy phần tử không đúng");
        } else {
            System.out.println("Lấy phần tử đúng");
        }

        list.set(1, "Programming");
        if (!list.get(1).equals("Programming")) {
            System.out.println("Set phần tử không đúng");
        } else {
            System.out.println("Set phần tử đúng");
        }

        if (!list.isContain("Java")) {
            System.out.println("Không tìm thấy phần tử Java");
        } else if (list.isContain("Python")) {
            System.out.println("Sai kết quả cho phần tử không có trong danh sách");
        } else {
            System.out.println("Test isContain passed!");
        }

        list.remove("Java");
        if (list.size() != 2) {
            System.out.println("Số lượng phần tử không đúng sau khi remove");
        } else if (list.isContain("Java")) {
            System.out.println("Java chưa được xóa");
        } else {
            System.out.println("Test remove passed!");
        }

        for (String item : list) {
            System.out.println(item);
        }
        System.out.println("Test iterator passed!");
    }
}
