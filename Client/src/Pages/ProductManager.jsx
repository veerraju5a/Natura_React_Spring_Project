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
    try {
      const product = await getProductById(productId);
      setFormData(product);
      setEditingProductId(productId);
    } catch (error) {
      console.error('Error fetching product for edit:', error);
    }
  };

  const handleDelete = async (productId) => {
    try {
      await deleteProduct(productId);
      fetchProducts();
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
          value={formData.productname}
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
              <h2>{product.productname}</h2>
              <p>{product.description}</p>
              <p>Weight: {product.weight} kg</p>
              <p>Price: ${product.price}</p>
              <img
               src={`../images/${product.img}`}
              //src={`data:image/png;base64,${props.img}`}
              // src={base64Image}

              width={189}
              height={189}
              loading="lazy"
              alt="Fresh Orangey"
            />
              <p>Image: {product.img}</p>
            </div>
            <div className="product-actions">
              <button onClick={() => handleEdit(product.productid)} className="edit-button">Edit</button>
              <button onClick={() => handleDelete(product.productid)} className="delete-button">Delete</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ProductManager;
