////package com.revshop.main;
////
////import java.util.Scanner;
////
////import com.revshop.controller.CartController;
////import com.revshop.controller.ProductController;
////import com.revshop.controller.UserController;
////import com.revshop.controller.FavoriteController;
////
////public class Main {
////
////    public static void main(String[] args) {
////
////        Scanner sc = new Scanner(System.in);
////
////        UserController userController = new UserController(sc);
////        ProductController productController = new ProductController();
////        CartController cartController = new CartController();
////        FavoriteController favoriteController = new FavoriteController();
////
////        int userId = -1; // not logged in
////
////        while (true) {
////
////            // ========== NOT LOGGED IN ==========
////            if (userId == -1) {
////
////                System.out.println("\n1. Register");
////                System.out.println("2. Login");
////                System.out.println("3. Exit");
////                System.out.print("Enter choice: ");
////
////                int choice = Integer.parseInt(sc.nextLine());
////
////                switch (choice) {
////                    case 1 -> userController.register();
////                    case 2 -> userId = userController.login();
////                    case 3 -> System.exit(0);
////                    default -> System.out.println("Invalid choice");
////                }
////            }
////
////            // ========== LOGGED IN ==========
////            else {
////
////                System.out.println("\n1.View Products");
////                System.out.println("2.Add To Cart");
////                System.out.println("3.Update Cart Item");
////                System.out.println("4.Remove Cart Item");
////                System.out.println("5.View Cart");
////                System.out.println("6.Add Favorite");
////                System.out.println("7.View Favorites");
////                System.out.println("8.Remove Favorite");
////                System.out.println("9.Logout");
////                System.out.print("Enter choice: ");
////
////                int choice = Integer.parseInt(sc.nextLine());
////
////                switch (choice) {
////                    case 1 -> productController.showProducts();
////                    case 2 -> cartController.addItem(userId);
////                    case 3 -> cartController.updateItem(userId);
////                    case 4 -> cartController.removeItem(userId);
////                    case 5 -> cartController.viewCart(userId);
////                    case 6 -> favoriteController.addFavorite(userId);
////                    case 7 -> favoriteController.viewFavorites(userId);
////                    case 8 -> favoriteController.removeFavorite(userId);
////                    case 9 -> {
////                        userId = -1;
////                        System.out.println("Logged out successfully");
////                    }
////                    default -> System.out.println("Invalid choice");
////                }
////            }
////        }
////    }
////}
//
//
//package com.revshop.main;
//
//import com.revshop.model.Payment;
//import com.revshop.model.Review;
//import com.revshop.service.PaymentServiceImpl;
//import com.revshop.service.ReviewService;
//
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//
//        Scanner sc = new Scanner(System.in);
//        PaymentServiceImpl paymentService = new PaymentServiceImpl();
//        ReviewService reviewService = new ReviewService();
//
//        int choice = 0;
//
//        while (choice != 3) {
//
//            System.out.println("1. Enter Payment");
//            System.out.println("2. Review");
//            System.out.println("3. Exit");
//            System.out.println("Enter choice:");
//            choice = sc.nextInt();
//
//            switch (choice) {
//
//                case 1:
//                    System.out.println("Enter Order Id:");
//                    int orderId = sc.nextInt();
//
//                    System.out.println("Enter Amount:");
//                    double amount = sc.nextDouble();
//                    sc.nextLine();
//
//                    System.out.println("Enter Payment Method:");
//                    String paymentMethod = sc.nextLine();
//
//                    System.out.println("Enter Payment Status:");
//                    String paymentStatus = sc.nextLine();
//
//                    Payment payment = new Payment();
//                    payment.setOrderId(orderId);
//                    payment.setAmount(amount);
//                    payment.setPaymentMethod(paymentMethod);
//                    payment.setPaymentStatus(paymentStatus);
//
//                    if (paymentService.processPayment(payment)) {
//                        System.out.println("Payment inserted successfully");
//                    } else {
//                        System.out.println("Payment failed");
//                    }
//                    break;
//
//                case 2:
//                    System.out.println("Enter Product Id:");
//                    int productId = sc.nextInt();
//
//                    System.out.println("Enter User Id:");
//                    int userId = sc.nextInt();
//
//                    System.out.println("Enter Rating:");
//                    int rating = sc.nextInt();
//                    sc.nextLine();
//
//                    System.out.println("Enter Review Comment:");
//                    String comment = sc.nextLine();
//
//                    Review review = new Review();
//                    review.setProductId(productId);
//                    review.setUserId(userId);
//                    review.setRating(rating);
//                    review.setReviewComment(comment);
//
//                    if (reviewService.submitReview(review)) {
//                        System.out.println("Review inserted successfully");
//                    } else {
//                        System.out.println("Review failed");
//                    }
//                    break;
//
//                case 3:
//                    System.out.println("Exiting application");
//                    break;
//
//                default:
//                    System.out.println("Invalid choice");
//            }
//        }
//
//        sc.close();
//    }
//}


package com.revshop.main;

import com.revshop.model.Payment;
import com.revshop.service.IPaymentService;
import com.revshop.service.PaymentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        IPaymentService paymentService = new PaymentServiceImpl();

        while (true) {
            try {
                System.out.println("\n===== PAYMENT MENU =====");
                System.out.println("1. Create Payment");
                System.out.println("2. View Payment by Id");
                System.out.println("3. View All Payments");
                System.out.println("4. Update Payment Status");
                System.out.println("5. Delete Payment");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {

                    case 1: {
                        Payment p = new Payment();

                        System.out.print("Enter Order Id: ");
                        p.setOrderId(sc.nextInt());

                        System.out.print("Enter Amount: ");
                        p.setAmount(sc.nextDouble());
                        sc.nextLine();

                        System.out.print("Enter Payment Method: ");
                        p.setPaymentMethod(sc.nextLine());

                        System.out.print("Enter Payment Status: ");
                        p.setPaymentStatus(sc.nextLine());

                        if (paymentService.processPayment(p))
                            System.out.println("Payment inserted successfully");
                        else
                            System.out.println("Payment insertion failed");
                        break;
                    }

                    case 2: {
                        System.out.print("Enter Payment Id: ");
                        int id = sc.nextInt();

                        Payment p = paymentService.viewPayment(id);
                        if (p != null) {
                            System.out.println("Payment Id: " + p.getPaymentId());
                            System.out.println("Order Id: " + p.getOrderId());
                            System.out.println("Amount: " + p.getAmount());
                            System.out.println("Method: " + p.getPaymentMethod());
                            System.out.println("Status: " + p.getPaymentStatus());
                        } else {
                            System.out.println("Payment not found");
                        }
                        break;
                    }

                    case 3: {
                        List<Payment> payments = paymentService.viewAllPayments();
                        if (payments.isEmpty()) {
                            System.out.println("No payments found");
                        } else {
                            for (Payment p : payments) {
                                System.out.println(
                                        p.getPaymentId() + " | " +
                                                p.getOrderId() + " | " +
                                                p.getAmount() + " | " +
                                                p.getPaymentMethod() + " | " +
                                                p.getPaymentStatus()
                                );
                            }
                        }
                        break;
                    }

                    case 4: {
                        System.out.print("Enter Payment Id: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Status: ");
                        String status = sc.nextLine();

                        if (paymentService.updatePaymentStatus(id, status))
                            System.out.println("Payment status updated successfully");
                        else
                            System.out.println("Update failed");
                        break;
                    }

                    case 5: {
                        System.out.print("Enter Payment Id: ");
                        int id = sc.nextInt();

                        if (paymentService.removePayment(id))
                            System.out.println("Payment deleted successfully");
                        else
                            System.out.println("Delete failed");
                        break;
                    }

                    case 6:
                        System.out.println("Exiting Payment Module");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Validation Error: " + e.getMessage());
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Unexpected error occurred");
                sc.nextLine();
            }
        }
    }
}
