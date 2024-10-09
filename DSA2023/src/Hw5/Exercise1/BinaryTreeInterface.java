package Hw5.Exercise1;

public interface BinaryTreeInterface<T> {
    T root(); // Trả về gốc của cây
    int size(); // Trả về số lượng node trong cây
    boolean isEmpty(); // Kiểm tra cây có rỗng không
    int numChildren(T p); // Trả về số lượng con của phần tử p
    T parent(T p); // Trả về phần tử cha của p
    T left(T p); // Trả về con trái của p
    T right(T p); // Trả về con phải của p
    T sibling(T p); // Trả về anh/chị/em của p
}

