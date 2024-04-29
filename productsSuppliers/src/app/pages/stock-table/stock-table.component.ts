import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { NzModalModule } from 'ng-zorro-antd/modal';

@Component({
  selector: 'app-stock-table',
  standalone: true,
  imports: [
    CommonModule,
    NzModalModule
  ],
  templateUrl: './stock-table.component.html',
  styleUrl: './stock-table.component.css'
})
export class StockTableComponent {
  private apiUrl = 'http://localhost:8080/api/v1/suppliers';

  supplier: any[] = [];
  supplierId: any;
  isVisible = false;
  isOkLoading = false;


  constructor(private http: HttpClient, private router: Router) { }

  getSuppliers(): Observable<any[]> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.get<any[]>(this.apiUrl, { headers });
  }

  async ngOnInit() {

    this.getSuppliers().subscribe(
      (response: any) => {
        this.supplier = response.data.content;
      },
      (error) => {
        console.error('Erro ao carregar usuários:', error);
      }
    );

    console.log(this.supplier)
  }

  openChangeSuppliers(supplierId: number): void {
    this.router.navigate(['/suppliers/' + supplierId]);
  }

  buttonDelete(supplierId: number): void {
    this.isVisible = true;
    this.supplierId = supplierId
  }

  handleOk(): void {
    this.isOkLoading = true;
    setTimeout(() => {
      this.isVisible = false;
      this.isOkLoading = false;
    }, 3000);

    this.deleteSuppliers(this.supplierId)

    location.reload();

  }

  deleteSuppliers(supplierId: number): void {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    this.http.delete(this.apiUrl + "/" + supplierId, { headers })
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