import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {
  private apiUrl = 'http://localhost:8080/api/v1/products';

  valueDescription: any;
  valueName: any;
  product: any;
  productId: any;

  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router) { }

  getProduct(productId: number): Observable<any[]> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.get<any[]>(this.apiUrl + "/" + productId, { headers });
  }

  async ngOnInit() {
    this.route.params.subscribe(params => {
      this.productId = params['productId'];
      console.log(this.productId);
      this.getProduct(this.productId).subscribe(
        (response: any) => {
          this.product = response.data;
          this.valueName = this.product.name;
          this.valueDescription = this.product.description;
        },
        (error) => {
          console.error('Erro ao carregar produto:', error);
        }
      );
    });
  }

  sendProduct(): void {
    console.log(this.valueName);
    console.log(this.valueDescription);

    const postData = {
      description: this.valueDescription,
      name: this.valueName
    };

    if (this.productId) {
      console.log('put' + postData);
      this.putProducts(this.productId, postData);
    } else {
      this.postProducts(postData);
    }

    setTimeout(() => {
      this.router.navigate(['/table']);
    }, 1000);
  }

  postProducts(postData: any): void {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.http.post(this.apiUrl, postData, { headers })
      .subscribe(
        response => {
          console.log('Post request successful:', response);
        },
        error => {
          console.error('Error making post request:', error);
        }
      );
  }

  putProducts(productId: number, postData: any): void {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.http.put(this.apiUrl + "/" + productId, postData, { headers })
      .subscribe(
        response => {
          console.log('Post request successful:', response);
        },
        error => {
          console.error('Error making post request:', error);
        }
      );
  }
}