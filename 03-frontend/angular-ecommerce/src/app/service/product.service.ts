import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../common/product';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = "http://localhost:8080/api/products"

  constructor(private http : HttpClient) { }


  getProductList(): Observable<Product[]> {
    return this.http.get<{
      _embedded : {products : Product[]},
      _links : Object[],
      page: Object[]
    }>(this.baseUrl)
    .pipe(
      map((val) => val._embedded.products)
    );
  }
}
