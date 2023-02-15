package com.capeddevil.geometry2d;

public class Box2D {


    protected Vector2 position;
    protected Vector2 size;

    public Box2D(Vector2 position, Vector2 size) {
        this.position = position;
        this.size = size;
    }

    public Vector2 getMinPoint() {
        double xMin = position.getX() - size.getX() / 2;
        double yMin = position.getY() - size.getY() / 2;
        return new Vector2(xMin, yMin);
    }

    public Vector2 getMaxPoint() {
        double xMax = position.getX() + size.getX() / 2;
        double yMax = position.getY() + size.getY() / 2;
        return new Vector2(xMax, yMax);
    }

    public boolean containsPoint(Vector2 point) {
        Vector2 minPoint = getMinPoint();
        Vector2 maxPoint = getMaxPoint();

        double x = point.getX();
        double y = point.getY();
        return (x >= minPoint.getX() && x <= maxPoint.getX() && y >= minPoint.getY() && y <= maxPoint.getY());
    }

    public Vector2[] getVertices() {
        // Calculate the center of the box
        var halfWidth = size.getX() / 2;
        var halfHeight = size.getY() / 2;
        double centerX = position.getX() + halfWidth;
        double centerY = position.getY() + halfHeight;

        // Calculate the vertices of the box
        Vector2[] vertices = new Vector2[4];
        vertices[0] = new Vector2(centerX - halfWidth, centerY - halfHeight); // bottom-left vertex
        vertices[1] = new Vector2(centerX + halfWidth, centerY - halfHeight); // bottom-right vertex
        vertices[2] = new Vector2(centerX + halfWidth, centerY + halfHeight); // top-right vertex
        vertices[3] = new Vector2(centerX - halfWidth, centerY + halfHeight); // top-left vertex


        return vertices;
    }

    public static Box2D fromMinMax(Vector2 minVertex, Vector2 maxVertex) {
        return new Box2D(minVertex, maxVertex.subtract( minVertex));
    }


}
