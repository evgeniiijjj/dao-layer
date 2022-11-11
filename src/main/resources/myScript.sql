SELECT product_name FROM customers LEFT JOIN orders o on customers.id = o.customer_id
WHERE LOWER(name) = LOWER(:name)