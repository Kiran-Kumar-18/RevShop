//package com.revshop.main;
//
//import java.util.Scanner;
//
//import com.revshop.controller.CartController;
//import com.revshop.controller.ProductController;
//import com.revshop.controller.UserController;
//import com.revshop.controller.FavoriteController;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        UserController userController = new UserController(sc);
//        ProductController productController = new ProductController();
//        CartController cartController = new CartController();
//        FavoriteController favoriteController = new FavoriteController();
//
//        int userId = -1; // not logged in
//
//        while (true) {
//
//            // ========== NOT LOGGED IN ==========
//            if (userId == -1) {
//
//                System.out.println("\n1. Register");
//                System.out.println("2. Login");
//                System.out.println("3. Exit");
//                System.out.print("Enter choice: ");
//
//                int choice = Integer.parseInt(sc.nextLine());
//
//                switch (choice) {
//                    case 1 -> userController.register();
//                    case 2 -> userId = userController.login();
//                    case 3 -> System.exit(0);
//                    default -> System.out.println("Invalid choice");
//                }
//            }
//
//            // ========== LOGGED IN ==========
//            else {
//
//                System.out.println("\n1.View Products");
//                System.out.println("2.Add To Cart");
//                System.out.println("3.Update Cart Item");
//                System.out.println("4.Remove Cart Item");
//                System.out.println("5.View Cart");
//                System.out.println("6.Add Favorite");
//                System.out.println("7.View Favorites");
//                System.out.println("8.Remove Favorite");
//                System.out.println("9.Logout");
//                System.out.print("Enter choice: ");
//
//                int choice = Integer.parseInt(sc.nextLine());
//
//                switch (choice) {
//                    case 1 -> productController.showProducts();
//                    case 2 -> cartController.addItem(userId);
//                    case 3 -> cartController.updateItem(userId);
//                    case 4 -> cartController.removeItem(userId);
//                    case 5 -> cartController.viewCart(userId);
//                    case 6 -> favoriteController.addFavorite(userId);
//                    case 7 -> favoriteController.viewFavorites(userId);
//                    case 8 -> favoriteController.removeFavorite(userId);
//                    case 9 -> {
//                        userId = -1;
//                        System.out.println("Logged out successfully");
//                    }
//                    default -> System.out.println("Invalid choice");
//                }
//            }
//        }
//    }
//}


package com.revshop.main;

import com.revshop.model.Payment;
import com.revshop.model.Review;
import com.revshop.service.PaymentService;
import com.revshop.service.ReviewService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        PaymentService paymentService = new PaymentService();
        ReviewService reviewService = new ReviewService();

        int choice = 0;

        while (choice != 3) {

            System.out.println("1. Enter Payment");
            System.out.println("2. Review");
            System.out.println("3. Exit");
            System.out.println("Enter choice:");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter Order Id:");
                    int orderId = sc.nextInt();

                    System.out.println("Enter Amount:");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Enter Payment Method:");
                    String paymentMethod = sc.nextLine();

                    System.out.println("Enter Payment Status:");
                    String paymentStatus = sc.nextLine();

                    Payment payment = new Payment();
                    payment.setOrderId(orderId);
                    payment.setAmount(amount);
                    payment.setPaymentMethod(paymentMethod);
                    payment.setPaymentStatus(paymentStatus);

                    if (paymentService.processPayment(payment)) {
                        System.out.println("Payment inserted successfully");
                    } else {
                        System.out.println("Payment failed");
                    }
                    break;

                case 2:
                    System.out.println("Enter Product Id:");
                    int productId = sc.nextInt();

                    System.out.println("Enter User Id:");
                    int userId = sc.nextInt();

                    System.out.println("Enter Rating:");
                    int rating = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Review Comment:");
                    String comment = sc.nextLine();

                    Review review = new Review();
                    review.setProductId(productId);
                    review.setUserId(userId);
                    review.setRating(rating);
                    review.setReviewComment(comment);

                    if (reviewService.submitReview(review)) {
                        System.out.println("Review inserted successfully");
                    } else {
                        System.out.println("Review failed");
                    }
                    break;

                case 3:
                    System.out.println("Exiting application");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
