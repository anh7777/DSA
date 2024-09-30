package Hw2_22001235_NguyenNgocAnh.Exercise3;

public class TestSimpleLinkedList {
    public static void main(String[] args) {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();

        assert list.isEmpty() : "Danh sách không phải là rỗng";
        System.out.println("Test isEmpty passed!");

        list.add("Hello");
        list.add("World");
        list.add("Java");

        assert list.size() == 3 : "Số lượng phần tử không đúng";
        System.out.println("Test size passed!");

        assert list.get(0).equals("Java") : "Phần tử đầu tiên không đúng";
        assert list.get(1).equals("World") : "Phần tử thứ hai không đúng";
        assert list.get(2).equals("Hello") : "Phần tử thứ ba không đúng";
        System.out.println("Test get passed!");

        list.set(1, "Programming");
        assert list.get(1).equals("Programming") : "Set phần tử không đúng";
        System.out.println("Test set passed!");

        assert list.isContains("Java") : " Không tìm thấy phần tử 'Java'";
        assert list.isContains("Programming") : "Không tìm thấy phần tử 'Programming'";
        assert !list.isContains("Python") : "Sai kết quả cho phần tử không có trong danh sách";
        System.out.println("Test isContains passed!");

        list.removeTop();
        assert list.size() == 2 : "Số lượng phần tử không đúng sau khi xóa đầu";
        assert !list.isContains("Java") : "'Java' chưa được xóa";
        System.out.println("Test removeTop passed!");

        list.removeBot();
        assert list.size() == 1 : "Số lượng phần tử không đúng sau khi xóa cuối";
        assert !list.isContains("Hello") : "'Hello' chưa được xóa";
        System.out.println("Test removeBot passed!");

        list.addBot("Python");
        assert list.size() == 2 : "Số lượng phần tử không đúng sau khi thêm vào cuối";
        assert list.get(1).equals("Python") : "Phần tử cuối không đúng";
        System.out.println("Test addBot passed!");

        System.out.println("Các phần tử trong danh sách:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("Tất cả các test đã thành công!");
    }
}
