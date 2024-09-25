package Hw1;

class Sphere {
    double radius, x, y, z;

    public Sphere(double r, double x, double y, double z) {
        this.radius = r;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double surfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    public double volume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }

    public boolean intersects(Sphere other) {
        double distance = Math.sqrt(Math.pow(this.x - other.x, 2) +
                Math.pow(this.y - other.y, 2) +
                Math.pow(this.z - other.z, 2));
        return distance < this.radius + other.radius;
    }

    public boolean contains(Sphere other) {
        double distance = Math.sqrt(Math.pow(this.x - other.x, 2) +
                Math.pow(this.y - other.y, 2) +
                Math.pow(this.z - other.z, 2));
        return distance + other.radius < this.radius;
    }
}
