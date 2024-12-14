// apiService.js
import axios from 'axios';

const API_BASE_URL = 'http://localhost:9090/product'; // Replace with your actual backend URL

// Create Product
export const createProduct = async (formData) => {
  const response = await axios.post(`${API_BASE_URL}/add`, formData, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  });
  return response.data;
};

// Get Product by ID
export const getProductById = async (productId) => {
  const response = await axios.get(`${API_BASE_URL}/${productId}`);
  return response.data;
};

// Get All Products
export const getAllProducts = async () => {
  const response = await axios.get(`${API_BASE_URL}/`);
  console.log(response.data)
  return response.data;
};

// Delete Product
export const deleteProduct = async (productId) => {
  const response = await axios.delete(`${API_BASE_URL}/del/${productId}`);
  return response.data;
};

// Update Product
export const updateProduct = async (productId, formData) => {
  const response = await axios.put(`${API_BASE_URL}/${productId}`, formData, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  });
  return response.data;
};
