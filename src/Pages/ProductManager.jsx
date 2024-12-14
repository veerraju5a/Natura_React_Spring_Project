// ProductManager.js
import React, { useState, useEffect } from 'react';
import { createProduct, getAllProducts, getProductById, deleteProduct, updateProduct } from './ProductApi';
import './ProductManager.css'; // Import CSS file

const ProductManager = () => {
  const [products, setProducts] = useState([]);
  const [formData, setFormData] = useState({
    productname: '',
    description: '',
    weight: '',
    price: '',
    img: '',
  });
  const [editingProductId, setEditingProductId] = useState(null);

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const data = await getAllProducts();
      setProducts(data);
    } catch (error) {
      console.error('Error fetching products:', error);
    }
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevState) => ({ ...prevState, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      if (editingProductId) {
        await updateProduct(editingProductId, formData);
      } else {
        await createProduct(formData);
      }
      setFormData({ productname: '', description: '', weight: '', price: '', img: '' });
      setEditingProductId(null);
      fetchProducts();
    } catch (error) {
      console.error('Error submitting product form:', error);
    }
  };

  const handleEdit = async (productId) => {
    const editWindow = window.open('', 'Edit Product', 'width=600,height=400');
    try {
      const product = await getProductById(productId);
      setEditingProductId(productId);
      
      editWindow.document.write(`
        <html>
          <head>
            <title>Edit Product</title>
            <style>
              body { font-family: Arial, sans-serif; margin: 20px; }
              form { display: flex; flex-direction: column; }
              input, textarea, button { margin: 10px 0; padding: 8px; }
            </style>
          </head>
          <body>
            <h1>Edit Product</h1>
            <form id="edit-form">
              <input name="productname" placeholder="Product Name" value="${product.productName}" required />
              <textarea name="description" placeholder="Description" required>${product.description}</textarea>
              <input name="weight" placeholder="Weight" type="number" value="${product.weight}" required />
              <input name="price" placeholder="Price" type="number" value="${product.price}" required />
              <input name="img" placeholder="Image URL" value="${product.img}" required />
              <button type="submit">Update</button>
            </form>
            <script>
              document.getElementById('edit-form').onsubmit = function(event) {
                event.preventDefault();
                const formData = new FormData(event.target);
                const data = Object.fromEntries(formData.entries());
                window.opener.handleUpdateProduct(${productId}, data);
                window.close();
              };
            </script>
          </body>
        </html>
      `);
    } catch (error) {
      console.error('Error fetching product for edit:', error);
    }
  };

  window.handleUpdateProduct = async (productId, data) => {
    try {
      await updateProduct(productId, data);
      fetchProducts();
      alert('Product updated successfully.');
    } catch (error) {
      console.error('Error updating product:', error);
    }
  };

  const handleDeleteConfirmation = (productId) => {
    const deleteWindow = window.open(
      '',
      'Delete Confirmation',
      'width=400,height=200'
    );

    deleteWindow.document.write(`
      <html>
        <head>
          <title>Confirm Delete</title>
          <style>
            body { font-family: Arial, sans-serif; text-align: center; margin-top: 50px; }
            button { margin: 10px; padding: 10px 20px; font-size: 16px; }
          </style>
        </head>
        <body>
          <h3>Are you sure you want to delete this product?</h3>
          <button id="yes-button">Yes</button>
          <button id="no-button">No</button>
          <script>
            document.getElementById('yes-button').onclick = function() {
              window.opener.handleDeleteAction(${productId});
              window.close();
            };
            document.getElementById('no-button').onclick = function() {
              window.close();
            };
          </script>
        </body>
      </html>
    `);
  };

  window.handleDeleteAction = async (productId) => {
    try {
      await deleteProduct(productId);
      fetchProducts();
      alert('Product deleted successfully.');
    } catch (error) {
      console.error('Error deleting product:', error);
    }
  };

  return (
    <div className="product-manager">
      <h1>Product Manager</h1>
      <form onSubmit={handleSubmit} className="product-form">
        <input
          name="productname"
          placeholder="Product Name"
          value={formData.productName}
          onChange={handleInputChange}
          className="form-input"
          required
        />
        <textarea
          name="description"
          placeholder="Description"
          value={formData.description}
          onChange={handleInputChange}
          className="form-input"
          required
        ></textarea>
        <input
          name="weight"
          placeholder="Weight"
          type="number"
          value={formData.weight}
          onChange={handleInputChange}
          className="form-input"
          required
        />
        <input
          name="price"
          placeholder="Price"
          type="number"
          value={formData.price}
          onChange={handleInputChange}
          className="form-input"
          required
        />
        <input
          name="img"
          placeholder="Image URL"
          value={formData.img}
          onChange={handleInputChange}
          className="form-input"
          required
        />
        <button type="submit" className="form-button">
          {editingProductId ? 'Update' : 'Create'} Product
        </button>
      </form>

      <ul className="product-list">
        {products.map((product) => (
          <li key={product.productid} className="product-item">
            <div className="product-details">
              <h2>{product.productid}</h2>
              <h2>{product.productName}</h2>
              <p>{product.description}</p>
              <p>Weight: {product.weight} kg</p>
              <p>Price: ${product.price}</p>
              <img
                src={`../images/${product.img}`}
                width={189}
                height={189}
                loading="lazy"
                alt={product.productname}
              />
            </div>
            <div className="product-actions">
              <button onClick={() => handleEdit(product.productid)} className="edit-button">Edit</button>
              <button onClick={() => handleDeleteConfirmation(product.productid)} className="delete-button">Delete</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ProductManager;
