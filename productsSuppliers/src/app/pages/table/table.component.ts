import { CommonModule } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { NzModalModule } from 'ng-zorro-antd/modal';

@Component({
  selector: 'app-table',
  standalone: true,
  imports: [
    CommonModule,
    NzModalModule
  ],
  templateUrl: './table.component.html',
  styleUrl: './table.component.css'
})
export class TableComponent {
  private apiUrl = 'http://localhost:8080/api/v1/products';

  products: any[] = [];
  productId: any;
  isVisible = false;
  isOkLoading = false;


  constructor(private http: HttpClient, private router: Router) { }

  getProducts(): Observable<any[]> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.get<any[]>(this.apiUrl, { headers });
  }

  async ngOnInit() {

    this.getProducts().subscribe(
      (response: any) => {
        this.products = response.data.content;
      },
      (error) => {
        console.error('Erro ao carregar usuários:', error);
      }
    );

    console.log(this.products)
  }

  openChangeProducts(productId: number): void {
    this.router.navigate(['/products/' + productId]);
  }

  buttonDelete(productId: number): void {
    this.isVisible = true;
    this.productId = productId
  }

  handleOk(): void {
    this.isOkLoading = true;
    setTimeout(() => {
      this.isVisible = false;
      this.isOkLoading = false;
    }, 3000);

    this.deleteProducts(this.productId)

    location.reload();

  }

  deleteProducts(productId: number): void {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.http.delete(this.apiUrl + "/" + productId, { headers })
      .subscribe(
        response => {
          console.log('Post request successful:', response);
        },
        error => {
          console.error('Error making post request:', error);
        }
      );
  }


  handleCancel(): void {
    this.isVisible = false;
  }

}
