;; First define templates for the model classes so we can use them
;; in our pricing rules. This doesn't create any model objects --
;; it just tells Jess to examine the classes and set up templates
;; using their properties

(import gov.sandia.jess.example.pricing.model.Order)
(import gov.sandia.jess.example.pricing.model.OrderItem)
(import gov.sandia.jess.example.pricing.model.Customer)
(import gov.sandia.jess.example.pricing.model.Offer)
(import gov.sandia.jess.example.pricing.model.items.CreditCard)

;;añadimos la lista de la database
(import catalog.model.CatalogItem)

(deftemplate Order       (declare (from-class Order)))
(deftemplate OrderItem   (declare (from-class OrderItem)))
(deftemplate CatalogItem (declare (from-class CatalogItem)))
(deftemplate Customer    (declare (from-class Customer)))
(deftemplate CreditCard  (declare (from-class CreditCard)))

;; Now define the pricing rules themselves. Each rule matches a set
;; of conditions and then creates an Offer object to represent a
;; bonus of some kind given to a customer. The rules assume that
;; there will be just one Order, its OrderItems, and its Customer in 
;; working memory, along with all the CatalogItems.

(defrule 10%-volume-discount
    "Give a 10% discount to everybody who spends more than $100."
    ?o <- (Order {total > 100})
    =>
    (printout t "   -----------------------------------------" crlf)
    (add (new Offer "10% volume discount" (/ ?o.total 10))))

(defrule 25%-multi-item-discount
    "Give a 25% discount on items the customer buys three or more of."
    (OrderItem {quantity >= 3} (price ?price))
    =>
    (printout t "   -----------------------------------------" crlf)
    (add (new Offer "25% multi-item discount" (/ ?price 4))))

(defrule free-cd-rw-disks
    "If somebody buys a CD writer, send them a free sample of CD-RW
    disks, catalog number 2; but only if they're a repeat customer.
    We use a regular expression to match the CD writer's description."
    (CatalogItem (partNumber ?partNumber) (description /CD Writer/))
    (CatalogItem (partNumber 2) (price ?price))
    (OrderItem (partNumber ?partNumber))
    (Customer {orderCount > 1})
    =>
    (printout t "   -----------------------------------------" crlf)
    (add (new Offer "Free CD-RW disks" ?price)))

;; XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

(defrule IPHONE-24-MESES-SIN-INTERESES
    "En la compra de un “IFON 11 Pro”, con tarjetas Banamex, ofrecer 24 meses sin intereses."

    ;;(CatalogItem (partNumber ?partNumber) (description /IFON 11 PRO DE LA MARCA APPLE/))
    (CatalogItem (partNumber ?partNumber) (description "IFON11PRO_BD"))
    (OrderItem (partNumber ?partNumber))
    (CreditCard (NOMBRE /BANAMEX/))

    =>
    (printout t "   -----------------------------------------" crlf)
    (add (new Offer "24 MESES SIN INTERESES!!!")))
    ;;SOLO LA DESCRIPTION

;; -------------------------------------------------------------------------

(defrule SAMSUNG-12-MESES-SIN-INTERESES
    "En la compra de un “SAMSUNG Note 11”, con tarjeta de Liverpool VISA, ofrecer 12 meses sin intereses."

    ;;(CatalogItem (partNumber ?partNumber) (description /NOTE 11 DE LA MARCA SAMSUNG/))
    ;;(CatalogItem (partNumber ?partNumber) (description "NOTE11DELAMARCASamsung"))
    (CatalogItem (partNumber ?partNumber) (description "NOTE11_BD"))
    (OrderItem (partNumber ?partNumber))
    (CreditCard (NOMBRE /LIVERPOOL VISA/))

    =>
    (printout t "   -----------------------------------------" crlf)
    (add (new Offer "12 MESES SIN INTERESES!!!")))
    ;;SOLO LA DESCRIPTION

;; -------------------------------------------------------------------------

(defrule MCBOOK-VALES
    "En la compra de una “MacBook Air”, ofrecer 100 pesos en vales por cada 1000 pesos en la compra."

    ;;(CatalogItem (partNumber ?partNumber) (description /MCBOOK AIR DE LA MARCA APPLE/))
    (CatalogItem (partNumber ?partNumber) (description "MCBOOKAIR_BD"))
    (OrderItem (partNumber ?partNumber))
    ?o <- (Order {total >= 1000})

    =>
    (printout t "   -----------------------------------------" crlf)
    (add (new Offer "VALES DE DESPENSA " 0 (/ ?o.total 10))))